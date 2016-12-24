(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(def default-frequencies {\A 0 \T 0 \C 0 \G 0})

(defn nucleotide-counts
  [dna]
  (merge default-frequencies (frequencies dna)))

(defn count
  [nucleotide dna]
  {:pre [(default-frequencies nucleotide)]}
  ((nucleotide-counts dna) nucleotide))
