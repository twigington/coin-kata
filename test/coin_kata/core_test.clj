(ns coin-kata.core-test
  (:require [clojure.test :refer :all]
            [coin-kata.core :refer :all]))

(deftest cents15
  (testing "An input of 15 with [1, 5, 10, 25, 100] should return fifteen cents or [0, 1, 1, 0, 0]"
    (is (= [0 1 1 0 0] (make-change 15 [1 5 10 25 100])))))

(deftest cents40
  (testing "An input of 40 with [1, 5, 10, 25, 100] should return two dimes or [0, 1, 1, 1, 0]"
    (is (= [0 1 1 1 0] (make-change 40 [1 5 10 25 100])))))

(deftest cents41
  (testing "An input of 41 with [1, 5, 10, 25, 100] should return two dimes or [1, 1, 1, 1, 0]"
    (is (= [1 1 1 1 0] (make-change 41 [1 5 10 25 100])))))

(deftest cents0
  (testing "Test Zero"
    (is (= [0 0 0 0 0] (make-change 0 [1 5 10 25 100])))))

(deftest empty-denomination-list
  (testing "An empty denomination list should return an empty list"
    (is (= [] (make-change 99 [])))))

(deftest pennies-from-heaven
  (testing "When using only pennies, return the amount"
    (is (= [999] (make-change 999 [1])))))
