(ns robot-simulator)

(defn robot [coordinates direction]
  {:bearing direction
   :coordinates coordinates})

(defn turn-right [direction]
  ({:west :north
    :north :east
    :east :south
    :south :west} direction))

(defn turn-left [direction]
  ({:north :west
    :west :south
    :south :east
    :east :north} direction))

(defn move-right [robot]
  (assoc robot :bearing (turn-right (:bearing robot))))

(defn move-left [robot]
  (assoc robot :bearing (turn-left (:bearing robot))))

(defn move-to-north [robot]
  (-> robot (update-in [:coordinates :y] inc) (assoc :bearing :north)))

(defn move-to-east [robot]
  (-> robot (update-in [:coordinates :x] inc) (assoc :bearing :east)))

(defn move-to-south [robot]
  (-> robot (update-in [:coordinates :y] dec) (assoc :bearing :south)))

(defn move-to-west [robot]
  (-> robot (update-in [:coordinates :x] dec) (assoc :bearing :west)))

(defn advance [robot direction]
  (condp = direction
    :north (move-to-north robot)
    :east (move-to-east robot)
    :south (move-to-south robot)
    :west (move-to-west robot)))

(defn move-ahead [robot]
  (advance robot (:bearing robot)))

(defn move [robot instruction]
  (condp = instruction
    \R (move-right robot)
    \L (move-left robot)
    \A (move-ahead robot)))

(defn simulate [instructions robot]
  (reduce move robot instructions))
