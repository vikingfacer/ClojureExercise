(ns app.core
	(:gen-class))

(use 'clojure.pprint)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})



(defn -main 
  
 []
 
 (pprint ((comp :intelligence :attributes) character)))















