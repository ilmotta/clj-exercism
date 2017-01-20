(ns robot-name)

;;; Domain model
(defrecord Robot
  [id name])

;;; Store API
(defn ^:private unique-robot-names? [robots]
  (->> robots (map :name) frequencies (map second) (some #(> % 1)) nil?))

(def ^:private validate-store
  (comp unique-robot-names? vals :robots))

(def ^:private store
  (atom {:robots {}}))

(set-validator! store validate-store)

(defn ^:private fetch-robot [robot]
  (get-in @store [:robots (:id robot)]))

(defn ^:private add-robot [robot]
  (swap! store assoc-in [:robots (:id robot)] robot)
  robot)

(defn ^:private update-robot [robot]
  (swap! store assoc-in [:robots (:id robot)] robot)
  robot)

(defn ^:private generate-robot-id []
  (inc (count (@store :robots))))
;; ----------------------------------------------------------------------------


;;; Helper functions
(defn ^:private generate-name
  "Generate a random name in the format of two uppercase letters followed by
  three digits, such as RX837 or BC811."
  []
  (let [alphabet (seq "ABCDEFGHIJKLMNOPQRSTUVXYZ")]
    (str (rand-nth alphabet) (rand-nth alphabet)
         (rand-int 10) (rand-int 10) (rand-int 10))))
;; ----------------------------------------------------------------------------


(defn robot
  "Build robot, add to store and return it"
  []
  (add-robot (map->Robot {:id (generate-robot-id) :name (generate-name)})))

(def robot-name
  "Return robot name"
  (comp :name fetch-robot))

(defn reset-name
  "Reset robot name to a new random name, update store and return the updated
  robot"
  [robot]
  (update-robot (assoc robot :name (generate-name))))
