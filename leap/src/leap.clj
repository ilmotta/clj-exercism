(ns leap)

(defn leap-year?
  "Returns true on every year that is evenly divisible by 4 except if it is
  evenly divisible by 100 and unless it is also evenly divisible by 400."
  [year]
  (and (zero? (mod year 4))
       (or (pos? (mod year 100))
           (zero? (mod year 400)))))
