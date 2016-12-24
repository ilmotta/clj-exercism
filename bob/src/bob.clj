(ns bob
  (:require [clojure.string :refer [blank? ends-with? trim]]))

(defn question? [sentence] (ends-with? sentence "?"))

(defn yell?
  [sentence]
  (and (> (count (re-seq #"[A-Z]" sentence)) 0)
       (= (count (re-seq #"[a-z]" sentence)) 0)))

(defn response-for
  [sentence]
  (condp apply [sentence]
    yell? "Whoa, chill out!"
    question? "Sure."
    blank? "Fine. Be that way!"
    "Whatever."))
