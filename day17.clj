; Given a string made up of letters a, b, and/or c, switch the position of letters a and b (change a to b and vice versa). Leave any incidence of c untouched.

; Example:
;
; 'acb' --> 'bca'
; 'aabacbaa' --> 'bbabcabb'

; implement
(defn switch [string]
  (clojure.string/replace string #"[ab]"  ; regex matches only "a" or "b"
    #(if (= % "a")        ; the anonymous function is called for each match
       "b"                ; if the match is "a", return "b"
       "a")))             ; otherwise (must be "b"), return "a"


;; Example walkthrough:
;; (switch "acb")
;; 1. Regex finds "a" -> function called with %="a" -> returns "b"
;; 2. "c" is not matched -> stays "c"
;; 3. Regex finds "b" -> function called with %="b" -> returns "a"
;; => final result: "bca"

; test
; execute implement function
(defn tester [arg exp]
  (= (switch arg) exp))

; args & exception
(comment
  (tester "abc" "bac")
  (tester "aaabcccbaaa" "bbbacccabbb")
  (tester "ccccc" "ccccc")
  (tester "abababababababab" "babababababababa")
  (tester "aaaaa" "bbbbb"))
