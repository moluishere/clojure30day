; There is a bus moving in the city, and it takes and drop some people in each
; bus stop.
;
; You are provided with a list (or array) of integer pairs. Elements of each
; pair represent number of people get into bus (The first item) and number of
; people get off the bus (The second item) in a bus stop.
;
; Your task is to return number of people who are still in the bus after the
; last bus station (after the last array). Even though it is the last bus stop,
; the bus is not empty and some people are still in the bus, and they are
; probably sleeping there :D
;
; Take a look on the test cases.
;
; Please keep in mind that the test cases ensure that the number of people in
; the bus is always >= 0. So the return integer can't be negative.
;
; The second value in the first integer array is 0, since the bus is empty in
; the first bus stop.



; step 1
; (defn number [bus-stops]
;   (fn [on off] (- on off)))

; step 2
; keywords: reduce / map
; (defn number [bus-stops]
;   (reduce + ; + => function
;           (map (fn [[on off (- on off)]]))  ; map... => init
;           bus-stops)) ; bus-stops => coll

; step 3 (no need map)
; keywords: reduce / fn / destructuring
(defn number [bus-stops]
  (reduce (fn [total [on off]] (+ total (- on off))) ; fn => function
          0 ; 0 => init (total)
          bus-stops)) ; bus-stops => coll

; reduce function
; => (reduce f init coll)
; (reduce
;   (fn [accumulator current-item] ...)
;   initial-value
;   collection)

; (fn [total [on off]] ...)
; 第一個是 total（acc 累積值）
; 第二個是 current-item（這裡是一對 [on off]）

(defn tester [bus-stops exp]
  (= exp (number bus-stops)))

; otehrs
; (defn number
;   [bus-stops]
;   (reduce - (apply map + bus-stops)))

(comment
  (tester [[10 0] [3 5] [5 8]] 5)
  (tester [[3 0] [9 1] [4 10] [12 2] [6 1] [7 10]] 17)
  (tester [[3 0] [9 1] [4 8] [12 2] [6 1] [7 8]] 21))
