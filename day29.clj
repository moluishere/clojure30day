; Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
;
; Examples:
; a = "xyaabbbccccdefww"
; b = "xxxxyyyyabklmopq"
; longest(a, b) -> "abcdefklmopqwxy"
;
; a = "abcdefghijklmnopqrstuvwxyz"
; longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

; keywords: concat, distinct, sort, apply str, seq
; Key functions used:
; - concat: combines two strings into a single sequence (strings are automatically treated as sequences of characters)
; - distinct: removes duplicate characters from the sequence
; - sort: sorts characters alphabetically
; - apply str: converts sequence of characters back to a string
; Note: In Clojure, strings are seqable - when used in sequence operations, they're treated as sequences of characters

; implement
(defn longest [s1 s2]
  (->> (concat s1 s2)
       (distinct)
       (sort)
       (apply str)))

; test
; execute implement function
(defn tester [s1 s2 exp]
  (= (longest s1 s2) exp))

; args & exception
(comment
  (tester "aretheyhere" "yestheyarehere" "aehrsty")
  (tester "loopingisfunbutdangerous" "lessdangerousthancoding" "abcdefghilnoprstu")
  (tester "inmanylanguages" "theresapairoffunctions" "acefghilmnoprstuy"))
