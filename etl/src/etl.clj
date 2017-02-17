(ns etl)

(defn transform [input]
  (reduce (fn [m [points values]]
            (as-> values res
              (map clojure.string/lower-case res)
              (zipmap res (repeat (count res) points))
              (merge m res)))
          {}
          input))
