(ns app.core
  (:gen-class))

(defn Ch3Pr1 
  "problem from chapter 3 problem 1"
  []
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
  (defn add100 
    [addthis]
    (+ addthis 100))
  	(let [qu (quote (add100 9) )] 
     (println qu (add100 9) )))

(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!")
  (Ch3Pr1)
  (Ch3Pr2)
  )

