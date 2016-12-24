(ns hamming
  (:require [clojure.string :refer [blank?]]
            [clojure.data :refer [diff]]))

(defn distance
  [a b]
  (when (= (count a) (count b))
    (->> (diff (seq a) (seq b))
         ((comp seq first))
         (remove (comp blank? str))
         count)))
