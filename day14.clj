; Trolls are attacking your comment section!
;
; A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
;
; Your task is to write a function that takes a string and return a new string with all vowels removed.
;
; For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
;
; Note: for this kata y isn't considered a vowel.

; clojure.string/replace -> It returns a new string where parts of the input string are replaced based on a match.

; #""     -> In Clojure, #"" defines a regular expression literal.
; (?i)    -> This is a regex flag meaning case-insensitive. With it, a and A are treated as the same.
; [aeiou] -> Square brackets define a character class. [aeiou] means “match any one character that is a, e, i, o, or u”.

; implement
(defn disemvowel [string]
  (clojure.string/replace string #"(?i)[aeiou]" ""))

; test
; execute implement function
(defn tester [arg exp]
  (= (disemvowel arg) exp))

; args & exception
(comment
  (tester "This website is for losers LOL!" "Ths wbst s fr lsrs LL!"))
