(ns length)

;Defining length fn using recursion

(defn length [coll]
  (let [empty-result 0
        coll-minus-first (rest coll)]
    (if
      (empty? coll)
      empty-result
      (+ 1 (length coll-minus-first)))))

(length [])
(length [1])
(length (range 10))

;Defining length fn with tail-recursion

(defn length-with-tail-recursion-helper
  [coll acc]
  (if (empty? coll)
    acc
    (let [rest  (rest coll)]
      (recur rest (inc acc)))))

(defn length-with-tail-recursion [coll]
  (length-with-tail-recursion-helper coll 0))

(length-with-tail-recursion [])
(length-with-tail-recursion [1])
(length-with-tail-recursion (range 10))
