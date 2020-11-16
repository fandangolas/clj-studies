(ns recursive-implementations.map)

;Defining map fn using recursion

(defn map* [f coll]
  (lazy-seq
    (if (empty? coll)
      ()
      (let [first (first coll)
            rest  (rest coll)]
        (cons (f first) (map* f rest))))))

(comment
  (map* inc [])
  (map* inc [1])
  (map* inc (range 10))
  (map* inc (range)))

;Defining a map fn with tail-recursion using loop + recur

(defn tail-recursive-map*
  [f coll]

  (loop [coll coll acc []]
    (if (empty? coll)
      acc
      (let [first (first coll)
            rest  (rest coll)
            new-acc (conj acc (f first))]
        (recur rest new-acc)))))

(comment
  (tail-recursive-map* inc [])
  (tail-recursive-map* inc [1])
  (tail-recursive-map* inc (range 10)))