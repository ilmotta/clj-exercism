(ns queen-attack
  (:require [clojure.string :as string]))

(defn can-attack [{[br bc] :b, [wr wc] :w}]
  (or (= bc wc)
      (= br wr)
      (= (Math/abs (- br wr)) (Math/abs (- bc wc)))))

(defn board-place [{:keys [b w]} row col]
  (let [loc [row col]]
    (cond
      (= loc w) :chess/white
      (= loc b) :chess/black
      :else :chess/empty)))

(defn board-row [queens row]
  (map (partial board-place queens row) (range 8)))

(defn board [queens]
  (map (partial board-row queens) (range 8)))

;; I've completely separated the steps to build board data and to
;; actually render it. In case I want to output to a different format
;; (e.g. HTML, JSON) only the rendering functions below will need to
;; change.

(defn render-place [place]
  (get {:chess/white "W" :chess/black "B"} place "_"))

(defn board-string [queens]
  (-> (board queens)
      (->> (map #(string/join " " (map render-place %))))
      (->> (string/join "\n"))
      (str "\n")))
