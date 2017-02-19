(ns pangram
  (:require [clojure.set :as set]
            [clojure.string :as string]))

(def us-alphabet
  (set (map char (range (int \a) (inc (int \z))))))

(defn pangram?
  ([s] (pangram? s us-alphabet))
  ([s alphabet]
   (set/subset? alphabet (set (string/lower-case s)))))
