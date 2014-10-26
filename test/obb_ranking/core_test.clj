(ns obb-ranking.core-test
  (:use clojure.test obb-ranking.core))

(deftest smoke-test
  (is calculate))

(deftest calculate-ratings
  (let [[p1 p2] (calculate {:rating 1500 :rd 50 :volatility 0.06}
                           {:rating 500 :rd 350 :volatility 0.06})]
    (is (> (:rating p1 1500)))))

(deftest default-player-test
  (let [default (default-player)]
    (is (< 0 (default :rating)))
    (is (< 0 (default :volatility)))
    (is (< 0 (default :rd)))))
