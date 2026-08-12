; Clock shows h hours, m minutes and s seconds after midnight.
;
; Your task is to write a function which returns the time since midnight in
; milliseconds.
;
; Example:
; h = 0
; m = 1
; s = 1
;
; result = 61000
; Input constraints:
;
; 0 <= h <= 23
; 0 <= m <= 59
; 0 <= s <= 59

; 1 hr = 60 * 60 * 1000 = 3,600,000
; 1 m =  60 * 1000 = 60,000
; 1 sec = 1,000

; keywords => ->> thread last
(defn past [h m s]
  (->> h
       (* 60)
       (+ m)
       (* 60)
       (+ s)
       (* 1000)))

; (defn past [h m s]
;   (* 1000 (+ (* h 3600) (* m 60) s)))

(defn tester [h m s e]
  (= (past h m s) e))

(comment
  (tester 0 1 1 61000)
  (tester 1 1 1 3661000)
  (tester 0 0 0 0)
  (tester 1 0 1 3601000)
  (tester 1 0 0 3600000))
