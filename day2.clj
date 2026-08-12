; You get an array of numbers, return the sum of all of the positives ones.
; Example [1,-4,7,12] => 1 + 7 + 12 = 20

; keywords: rest function, recursion
(defn positive-sum [input]
  (if (empty? input)
    0
    (+ (if (pos? (first input))
         (first input)
         0)
       (positive-sum (rest input)))))

; test
(defn tester [input exp]
  (= (positive-sum input) exp))

(comment
  (tester [] 0)
  (tester [1 2 3 4 5] 15)
  (tester [1 -2 3 4 5] 13)
  (tester [-1 2 3 4 -5] 9)
  (tester [-1 -2 -3 -4 -5] 0))

; Answer by others
; keywords: filter / reduce / ->> function
; (defn positive-sum
;   [coll]
;   (->> coll
;        (filter pos?)
;        (reduce +)))
; -> threading first
; ->> threading last

; Further Learning
; loop /recur
; 把 [1 2 3 4 5 6] 加總
; (defn sum-loop [xs]
;   (loop [remaining xs   ;; 初始值：整個序列
;          acc 0]         ;; 初始總和是 0
;     (if (empty? remaining)
;       acc              ;; 序列走完就回傳總和
;       (recur (rest remaining)      ;; 下一輪：把剩下的資料放進去
;              (+ acc (first remaining)))))) ;; 累加
