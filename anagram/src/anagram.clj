(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn ^:private diff-words [& more]
  (apply not= (map lower-case more)))

(defn ^:private same-chars [& more]
  (apply = (map (comp sort lower-case) more)))

(defn anagrams-for [word suggestions]
  (filter #(and (diff-words word %) (same-chars word %)) suggestions))
