(ns recursive-implementations.filter)

;Creating filter fn using recursion

(defn filter* [f? coll]
  (lazy-seq
    (if (empty? coll)
       ()
       (let [first (first coll)
             rest  (rest coll)]
         (if (f? first)
           (cons first (filter* f? rest))
           (filter* f? rest))))))

(comment
  (filter* identity [])
  (filter* even? [1])
  (filter* odd? [1])
  (filter* even? (range 10))
  (filter* odd? (range 10))
  (filter* even? (range)))

; filter fn with tail-recursion using loop + recur

(defn tail-recursive-filter* [f? coll]
  (loop [coll coll acc []]
    (if (empty? coll)
      acc
      (let [first (first coll)
            rest  (rest coll)]
        (if (f? first)
          (recur rest (conj acc first))
          (recur rest acc))))))

(comment
  (tail-recursive-filter* identity [])
  (tail-recursive-filter* even? [1])
  (tail-recursive-filter* odd? [1])
  (tail-recursive-filter* even? (range 10))
  (tail-recursive-filter* odd? (range 10)))


