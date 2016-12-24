(ns beer-song
  [:require [clojure.string :as string]])

(defn- pluralize
  [amount word]
  (cond-> (str amount " " word)
    (not= amount 1) (str "s")))

(defn- action
  [nth-verse]
  (cond
    (= nth-verse 0) "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    (= nth-verse 1) "Take it down and pass it around, no more bottles of beer on the wall.\n"
    (> nth-verse 1) (str "Take one down and pass it around, " (pluralize (dec nth-verse) "bottle") " of beer on the wall.\n")))

(defn- bottles-left
  [nth-verse]
  (if (= nth-verse 0)
    "No more bottles of beer on the wall, no more bottles of beer.\n"
    (let [plural (pluralize nth-verse "bottle")]
      (str plural " of beer on the wall, " plural " of beer.\n"))))

(defn verse
  [n]
  (string/join [(bottles-left n) (action n)]))

(defn sing
  ([start] (sing start 0 []))
  ([start end] (sing start end []))
  ([start end verses]
   (if (< start end)
     (string/join "\n" verses)
     (recur (dec start) end (conj verses (verse start))))))
