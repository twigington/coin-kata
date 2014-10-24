(ns coin-kata.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn make-change
  "Attempt to make change"
  ([amount denominations]
   (if (empty? denominations)
     []
     (let [denom (last denominations)]
       (if (< amount denom)
         (conj (make-change amount (drop-last denominations)) 0)
         (let [remaining (mod amount denom)
               coins (quot amount denom)]
           (conj (make-change remaining (drop-last denominations)) coins))))
     )))