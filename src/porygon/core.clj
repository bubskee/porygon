(ns porygon.core
    (:require [clojure.data.csv :as csv]
              [clojure.java.io :as io]))

(defn foo
      "I don't do a whole lot."
      ;; you dont give yourself enough credit, foo
      ([x] (println x "Hello, World!"))
      ([x y] (println x y "Farewell, Space!")))

(def pokes-in
  (with-open [reader (io/reader "resources/pokemon.csv")]
             (doall (csv/read-csv reader))))


(comment
  ;; grabbing types as keywords
  (->> poke-in
       ;remove header
       (drop 1)
       (map (fn [a] (nth a 2)))
       ;; coulda done (fn [[_ _ a]] a)
       (map (fn [s] (keyword (.toLowerCase s))))
       (set))

  ;; writing a new csv out ex
  (with-open [writer (io/writer "out-file.csv")]
             (csv/write-csv writer
                            [["abc" "def"]
                             ["ghi" "jkl"]]))
  )