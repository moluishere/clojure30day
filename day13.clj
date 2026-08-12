; Simple, given a string of words, return the length of the shortest word(s).
;
; String will never be empty and you do not need to account for different data types.

; implement
; clojure.string/split -> It splits a string into substrings, based on a regular expression (regex).

; #"" -> In Clojure, #"" defines a regular expression literal.
; \s  -> any whitespace character (space, tab, newline, etc.)
; +   -> “one or more” of the previous element.
(defn find_shortest [words]
  (->> (clojure.string/split words #"\s+")
       (map count)
       sort
       first))

; test
; execute implement function
(defn tester [arg exp]
  (= (find_shortest arg) exp))

; args & exception
(comment
  (tester "bitcoin take over the world maybe who knows perhaps" 3)
  (tester "turns out random test cases are easier than writing out basic ones" 3)
  (tester "lets talk about javascript the best language" 3)
  (tester "i want to travel the world writing code one day" 1)
  (tester "Lets all go on holiday somewhere very cold" 2))

