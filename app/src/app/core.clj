(ns app.core
  (:gen-class)
  (:require [clojure.java.io :as io] )
  (:require [clojure.string :as String]))

(def filename (io/resource "suspects.csv"))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(String/split % #",")
       (String/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                 (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       			  rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))


(defn glittery-names 
	"retruns the result of the glitter-filter but only names
 	 Problem 1
 	"
 	[ minimum-glitter records]
  
 	(into '() (map :name (filter #(>= (:glitter-index %) minimum-glitter) records) )))

(defn -main
  "I don't do a whole lot."
  []
  
  (println (glittery-names 3 (mapify (parse (slurp filename)))))
)






















