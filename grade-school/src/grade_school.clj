(ns grade-school)

(defn add [db student-name grade]
  (update db grade #(vec (conj % student-name))))

(defn grade [db grade]
  (db grade []))

(def sorted
  (partial reduce (fn [m [k v]] (assoc m k (sort v))) (sorted-map)))
