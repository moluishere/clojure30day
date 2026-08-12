; You ask a small girl,"How old are you?" She always says, "x years old", where
; x is a random number between 0 and 9.
;
; Write a program that returns the girl's age (0-9) as an integer.
;
; Assume the test input string is always a valid string. For example, the test
; input may be "1 year old" or "5 years old". The first character in the string
; is always a number.

; keywords:
; first (return java.lang.Character)
; Integer/parseInt (convert str to int)

(defn how-old [old-string]
  (let [old (str (first old-string))]
    (Integer/parseInt old)))

; test
(defn tester [old exp]
  (= (how-old old) exp))

(comment
 (tester "1 year old" 1)
 (tester "6 years old" 6))

; (comment
;   (how-old "1 year old"))

; Otehr Answers
;
; (defn how-old
;   [her-old]
;   (-> her-old
;       first
;       str
;       Integer/parseInt))

; (def how-old read-string)
