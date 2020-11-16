(ns recursive-implementations.length)

;Defining length fn using recursion

(defn length* [coll]
  (let [empty-result 0
        coll-minus-first (rest coll)]
    (if
      (empty? coll)
      empty-result
      (inc (length* coll-minus-first)))))

(comment
  (length* [])
  (length* [1])
  (length* (range 10)))

;Defining length fn with tail-recursion

(defn length-with-tail-recursion* [coll]
  (loop [coll coll acc 0]
    (if (empty? coll)
      acc
      (let [rest (rest coll)]
        (recur rest (inc acc))))))

(comment
  (length-with-tail-recursion* [])
  (length-with-tail-recursion* [1])
  (length-with-tail-recursion* (range 10)))
