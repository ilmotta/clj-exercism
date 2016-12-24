(ns phone-number)

(def invalid-phone
  "0000000000")

(defn as-phone
  [input]
  (let [numbers (clojure.string/replace input #"\D" "")]
    (if (re-find #"^1*\d{10}$" numbers)
      (clojure.string/replace (format "%11s" numbers) #"\s" "1")
      "00000000000")))

(def number
  (comp #(subs % 1) as-phone))

;; (defn number2
;;   [phone]
;;   (let [s (only-numbers phone)]
;;     (condp re-find s
;;       #"^.{10}$" s
;;       #"^1.{10}$" (subs s 1)
;;       invalid-phone)))

(def area-code
  (comp #(subs % 1 4) as-phone))

(defn pretty-print
  [phone]
  "")
