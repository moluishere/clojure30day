; Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
;
; Examples:
;
; spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
; spinWords( "This is a test") => returns "This is a test"
; spinWords( "This is another test" )=> returns "This is rehtona test"

; keywords: clojure.string/split, clojure.string/join, map, if, count, reverse
; Key functions used:
; - clojure.string/split: splits the string into words by spaces
; - map: transforms each word - reverses it if length >= 5, otherwise keeps it
; - reverse: reverses a string (converts to seq then back to string)
; - count: gets the length of a word
; - clojure.string/join: joins the words back with spaces

; implement
(defn spin-words [sentence]
  (->> (clojure.string/split sentence #" ")
       (map (fn [word-str]
              (if (>= (count word-str) 5)
                (apply str (reverse word-str))
                word-str)))
       (clojure.string/join " ")))

; test
; execute implement function
(defn tester [arg exp]
  (= (spin-words arg) exp))

; args & exception
(comment
  (tester "Welcome" "emocleW")
  (tester "Hey fellow warriors" "Hey wollef sroirraw")
  (tester "This is a test" "This is a test")
  (tester "This is another test" "This is rehtona test"))
