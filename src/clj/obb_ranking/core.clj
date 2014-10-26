(ns obb-ranking.core
  (:import org.goochjs.glicko2.RatingCalculator
           org.goochjs.glicko2.Rating
           org.goochjs.glicko2.RatingPeriodResults))

(def rating-system
  "Creates a new RankingCalculator"
  (RatingCalculator.))

(def rating-periods-result
  "Creates a new RatingPeriodResults"
  (RatingPeriodResults.))

(defn- dump-rating
  "Returns a hash for a RAting"
  [rating-player]
  {:rating (.getRating rating-player)
   :rd (.getRatingDeviation rating-player)
   :volatility (.getVolatility rating-player)})

(defn default-player
  "Returns a hash with default player values"
  []
  (let [player (Rating. "Player" rating-system)]
    (dump-rating player)))

(defn- create-rating
  "Creates a Rating with the given hash"
  [raw]
  (let [player (Rating. "Player" rating-system)]
    (.setRating player (raw :rating))
    (.setRatingDeviation player (raw :rd))
    (.setVolatility player (raw :volatility))
    player))

(defn calculate
  "Calculates rankings"
  [p1 p2]
  (let [results (RatingPeriodResults.)
        r1 (create-rating p1)
        r2 (create-rating p2)]
    (.addResult results r1 r2)
    (.updateRatings rating-system results)
    [(dump-rating r1) (dump-rating r2)]))
