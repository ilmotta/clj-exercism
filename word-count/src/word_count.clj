(ns word-count)

(def word-count
  (comp
    frequencies
    (partial re-seq #"\w+")
    clojure.string/lower-case))
