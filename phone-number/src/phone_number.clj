(ns phone-number
  (:require [clojure.string :as string]))

(defn ^:private as-phone
  [input]
  (let [numbers (string/replace input #"\D" "")]
    (if (re-find #"^1*\d{10}$" numbers)
      (string/replace (format "%11s" numbers) #"\s" "1")
      "00000000000")))

(def ^:private digit-groups
  (juxt #(subs % 0 1) #(subs % 1 4) #(subs % 4 7) #(subs % 7)))

(def ^:private without-area
  (comp rest digit-groups as-phone))

(def number
  (comp string/join without-area))

(def area-code
  (comp second digit-groups as-phone))

(def pretty-print
  (comp (partial apply format "(%s) %s-%s") without-area))
