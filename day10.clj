; Write a function that finds the sum of all its arguments.
;
; eg:
;
; (sum 1 2 3) ; => 6
; (sum 8 2) ; => 10
; (sum 1 2 3 4 5) ; => 15


; - Keywords
;   - sum - receive a vector argument
; implement
(defn sum [arg]
  (reduce + arg))

; test
; execute implement function
(defn tester [arg exp]
  (= (sum arg) exp))

; args & exception
(comment
  (tester [1 2] 3)
  (tester [5 7 9] 21)
  (tester [12 1 1 1 1] 16)
  (tester [12 1 1 1 1 1 1] 18))
