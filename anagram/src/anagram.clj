(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn diff-insensitive
  [a b]
  (not= (lower-case a) (lower-case b)))

(defn same-chars
  [a b]
  (= (sort (lower-case a)) (sort (lower-case b))))

(defn anagrams-for
  [word coll]
  (->> coll
       (filter (partial diff-insensitive word))
       (filter (partial same-chars word))))
