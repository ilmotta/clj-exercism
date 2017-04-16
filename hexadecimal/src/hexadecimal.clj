(ns hexadecimal)

(def hex-table
  {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9
   \a 10 \b 11 \c 12 \d 13 \e 14 \f 15})

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
