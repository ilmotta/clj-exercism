(ns phone-number
  (:require [clojure.string :as string]))

(defn ^:private as-groups
  [groups]
  (if (empty? groups) ["000" "000" "0000"] groups))

(def ^:private digit-groups
  (comp as-groups
        rest (partial re-find #"^1*(\d{3})(\d{3})(\d{4})$")
        #(string/replace % #"\D" "")))

(def number
  (comp string/join digit-groups))

(def area-code
  (comp first digit-groups))

(def pretty-print
  (comp (partial apply format "(%s) %s-%s") digit-groups))
