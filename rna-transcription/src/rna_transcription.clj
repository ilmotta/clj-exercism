(ns rna-transcription)

(defn to-rna
  [dna]
  {:pre [(re-matches #"^[ACGUT]+$" dna)]}
  (->> dna
       (vec)
       (map {\G \C \C \G \T \A \A \U})
       (clojure.string/join)))
