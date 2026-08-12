; The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
;
; Examples
; "din" => "((("
; "recede" => "()()()"
; "Success" => ")())())"
; "(( @" => "))(("
; Notes
; Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!

; keywords: clojure.string/lower-case, frequencies, map, apply str
; Key functions used:
; - clojure.string/lower-case: converts string to lowercase for case-insensitive comparison
; - frequencies: returns a map of characters to their occurrence counts
; - map: transforms each character based on its frequency
; - apply str: concatenates the sequence of "(" and ")" into a string

; implement
(defn encode-dups [text]
  (let [lowered (clojure.string/lower-case text)
        freq  (frequencies lowered)]
    (apply str (map #(if (= 1 (freq %)) "(" ")") lowered))))

; test
; execute implement function
(defn tester [text exp]
  (= (encode-dups text) exp))

; args & exception
(comment
  (tester "din" "(((")
  (tester "recede" "()()()")
  (tester "(( @" "))((")
  (tester "Success" ")())())")
  (tester "ABC" "(((")
  (tester "AaBbC" "))))("))

