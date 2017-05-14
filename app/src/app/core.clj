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


(defn append 
  "returns a list of suspects plus a new one"
  [suspectList suspect]
  (conj suspectList suspect))


(defn Valid-string? 
  "checks for a valid string"
  [string]
  (and (string? string) (not (empty? string)) string))

(defn Valid-glitter-index?
  "checks for a valid glitter-index"
  [glitter-index]
  (and (integer? glitter-index) (<= 0 glitter-index) glitter-index))

(def Valid-Map
  {:name Valid-string?
   :glitter-index Valid-glitter-index?})


(defn validate 
  "checks if the entered items are valid name: and :glitter-index
  	Meaning they exist"
   [KeyMap suspect]
   (let [Keylist (keys KeyMap)]
    ; Id like to make the list of keys to these 2 gets and then filter 
    ; to see if an invalid responce was given 
    ; first create keys 
    ; second map gets to valid map and supect
    ; filter results
   ( map (get Valid-Map KeyMap) (get suspect KeyMap) )))

(defn -main
  "I don't do a whole lot."
  []
  (def suspects (mapify(parse (slurp filename))))
  
  (println  suspects)
  (def strr "hi yo")
  (println strr (Valid-string? strr))
  (def intt 3 )
  (println intt (Valid-glitter-index? intt))

  (def tom {:name "tom" :glitter-index 9})
  (println ((Valid-Map :name) "tom") ((Valid-Map :glitter-index)  9) )

  (println(validate :name tom) (get tom :name) )  
)






















