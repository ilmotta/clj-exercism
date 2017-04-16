(ns hexadecimal)

(def hex-table
  (zipmap "0123456789abcdef" (range 16)))

(defn hex? [s]
  (every? hex-table s))

(defn resolve-addend [[exp factor]]
  (-> (Math/pow 16 exp) (* factor) int))

(defn hex-to-int [s]
  (if (hex? s)
    (->> (reverse s)
         (map hex-table)
         (map-indexed vector)
         (map resolve-addend)
         (apply +))
    0))
