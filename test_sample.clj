; implement
(defn function [arg]
  (* arg 2))

; test
; execute implement function
(defn tester [arg exp]
  (= (function arg) exp))

; args & exception
(comment
  (tester 3 6)
  (tester 5 10))
