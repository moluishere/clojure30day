; Task
; Given an array/list [] of integers , Construct a product array Of same size Such That prod[i] is equal to The Product of all the elements of Arr[] except Arr[i].
;
; productArray ({1,5,2}) ==> return {10,2,5}
; Explanation:
; The first element 10 is the product of all array's elements except the first element 1
;
; The second element 2 is the product of all array's elements except the second element 5
;
; The Third element 5 is the product of all array's elements except the Third element.

; implement
(defn product-array [xs]
  (map (fn [i]
         (let [left  (take i xs)         ; 取 i 左邊
               right (drop (inc i) xs)   ; 取 i 右邊
               others (concat left right)]
           (reduce * others)))           ; 把左右相乘
       (range (count xs))))              ; 索引 0 到 (count xs)-1

; test
; execute implement function
(defn tester [arg exp]
  (= (product-array arg) exp))

(comment
  (tester [12 20] [20 12])
  (tester [3 27 4 2] [216 24 162 324])
  (tester [13 10 5 2 9] [900 1170 2340 5850 1300])
  (tester [16 17 4 3 5 2] [2040 1920 8160 10880 6528 16320]))
