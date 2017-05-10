(ns app.core
  (:gen-class))

(defn Ch3Pr1 
  "problem from chapter 3 problem 1"
  []
  (println "Ch3Pr1")
  (let [string  "made a string"] 
    (println string))
  (let [vector (vec '(1 2 3 4 5 6) )]
    (println (str "this is a vector " vector)))
  (let [list '(l f 2 4 5 d :l)]
    (println (str "this is a list " list)))
  (let [hash-map (hash-map :k 3 :l 2 :s 15215  :j 5 :o 5 :p 5 :i 5 )]
    (println (str "this is a hash-map " hash-map)))
  (let [hashset (hash-set 8 :k :j 9 )]
    (println (str "this is a hash-set " hashset)))
  
  )

(defn Ch3Pr2
  "problem from chapter 3 problem 2"
  [ ]
  (println "Ch3Pr2")
  (defn add100 
    [addthis]
    (+ addthis 100))
  	(let [qu (quote (add100 9) )] 
     (println qu (add100 9) )))

(defn Ch3Pr3
    "problem from chapter 3 problem 3"
    []
  (println "Ch3Pr3")
  (defn dec-maker
    "returns function like -- but by arg"
    [ dec]
    #(- % dec))
  (def x-9 (dec-maker 9))
  (println (str  "x-9 "  (x-9 10))))

(defn Ch3Pr4
    "problem from chapter 3 problem 4
     	write a map-set function 
     	(map-set inc [ 1 1 2 2])
     	; => #(2 3)
    "
    []
    (defn map-set 
      "maps a function returns a set"
      [func &  args]
      (into {} (map func args)))
      (println "map set func " (map-set (fn [arg] (arg + 100)) 1 2 3 4 5) ))


(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!")
  (Ch3Pr1)
  (Ch3Pr2)
  (Ch3Pr3)
  (Ch3Pr4))

