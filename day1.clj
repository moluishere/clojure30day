; This function should test if the factor is a factor of base.
; Return true if it is a factor or false if it is not.

; keywords: mod function (https://clojuredocs.org/clojure.core/mod)
(defn check-for-factor [base factor]
  (= (mod base factor) 0))

(defn tester [base factor exp]
  (= (check-for-factor base factor) exp))
(comment
  (tester 10 2 true)
  (tester 63 7 true)
  (tester 2450 5 true)
  (tester 24612 3 true)
  (tester 9 2 false)
  (tester 653 7 false)
  (tester 2453 5 false)
  (tester 24617 3 false))
