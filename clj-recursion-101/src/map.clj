(ns map)

;Defining map fn using recursion

(defn map* [f coll]
  (if (empty? coll)
    ()
    (let [first (first coll)
          rest  (rest coll)]
      (cons (f first) (map* f rest)))))

(map* inc [])
(map* inc [1])
(map* inc (range 10))

;Defining a map fn with tail-recursion

(defn tail-recursive-map-helper [f coll acc]
  (if (empty? coll)
    acc
    (let [first (first coll)
          rest  (rest coll)
          new-acc (conj acc (f first))]
      (recur f rest new-acc))))

(defn tail-recursive-map* [f coll]
  (tail-recursive-map-helper f coll []))

(tail-recursive-map* inc [])
(tail-recursive-map* inc [1])
(tail-recursive-map* inc (range 10))