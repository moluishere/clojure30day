; Write a program that finds the summation of every number from 1 to num. The
; number will always be a positive integer greater than 0.

; For example:
;
; summation(2) -> 3
; 1 + 2
;
; summation(8) -> 36
; 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8

;keywords: range / reduce
; (defn summation [n]
;   (reduce + (range 1 n)))

; (range 1 n) => 1 ~ n-1
; inc 是 Clojure 的一個內建函數，意思是 increment，也就是「加一」。

(defn summation [n]
  (reduce + (range 1 (inc n))))

; (prn (summation 8))

;test
(defn tester [n e]
  ; (testing (str "Testing for " n)
      (= (summation n) e))

(comment
  (tester 1 1)
  (tester 8 36)
  (tester 22 253)
  (tester 100 5050)
  (tester 213 22791))
