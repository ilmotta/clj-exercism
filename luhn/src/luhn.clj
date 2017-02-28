(ns luhn
  (:require [clojure.string :as string]))

(defn ^:private digits [n]
  (map #(Long. %) (string/split (str n) #"")))

(defn ^:private map-nth
  "Map f over coll starting from start every n elements. start defaults to zero"
  ([n f coll] (map-nth 0 n f coll))
  ([start n f coll]
   (let [[a b] (split-at start coll)]
     (concat a (map-indexed #(if (zero? (mod %1 n)) (f %2) %2) b)))))

(defn ^:private bounded [limit n]
  (if (> n limit) (- n limit) n))

(defn checksum [n]
  (->> n
       digits
       reverse
       (map-nth 1 2 (partial * 2))
       (map-nth 1 2 (partial bounded 9))
       (apply +)
       (#(mod % 10))))

(def valid?
  (comp zero? checksum))

(defn add-check-digit [n]
  (let [x (* 10 n)]
    (+ x (- 10 (checksum x)))))
