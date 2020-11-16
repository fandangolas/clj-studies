(ns recursive-implementations.reduce)

;Implementing reduce only with recursion
(defn reduce*
  [f initial coll]
  (if (empty? coll)
    initial
    (let [[first & rest] coll]
      (recur f (f initial first) rest))))

(reduce* + 0 [1 2 3 4])