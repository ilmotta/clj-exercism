(ns phone-number
  (:require [clojure.string :as string]))

(def ^:private invalid-phone
  "00000000000")

(defn ^:private only-numbers
  [input]
  (string/replace input #"\D" ""))

(def ^:private valid?
  (partial re-find #"^1*\d{10}$"))

(defn ^:private pad-1
  [input]
  (-> input (->> (format "%11s")) (string/replace #"\s" "1")))

(defn ^:private as-phone
  [phone]
  (if (valid? phone) phone invalid-phone))

(def ^:private normalize
  (comp pad-1 as-phone only-numbers))

(def ^:private digit-groups
  (juxt #(subs % 0 1) #(subs % 1 4) #(subs % 4 7) #(subs % 7)))

(def ^:private without-area
  (comp rest digit-groups normalize))

(def number
  (comp string/join without-area))

(def area-code
  (comp second digit-groups normalize))

(def pretty-print
  (comp (partial apply format "(%s) %s-%s") without-area))
