(ns obb-ranking.core-test
  (:use clojure.test obb-ranking.core))

(deftest smoke-test
  (is calculate))

(deftest calculate-ratings
  (let [result (calculate {:rating 500 :rd 350 :volatility 40}
                 {:rating 1500 :rd 350 :volatility 40})]
    (println result)
    (is result)))

(deftest default-player-test
  (let [default (default-player)]
    (is (< 0 (default :rating)))
    (is (< 0 (default :volatility)))
    (is (< 0 (default :rd)))))
