(ns hexadecimal)

(def hex-table
  (zipmap "0123456789abcdef" (range 16)))

(defn hex? [s]
  (every? (set (keys hex-table)) s))

(defn build-addend [length index number]
  [(- (- length 1) index) number])

(defn resolve-addend [[exp factor]]
  (* factor (Math/pow 16 exp)))

(defn hex-to-int [s]
  (if (hex? s)
    (->> (seq s)
         (map hex-table)
         (map-indexed (partial build-addend (count s)))
         (map resolve-addend)
         (apply +)
         int)
    0))
