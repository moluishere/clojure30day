; Complete the solution so that it reverses all of the words within the string passed in.
;
; Example(Input --> Output):
;
; "The greatest victory is that which requires no battle" --> "battle no requires which that is victory greatest The"

; Keywords: string manipulation, split, reverse, join, regex, word order

; implement
(defn reverse-words [sentence]
  (clojure.string/join " " (reverse (clojure.string/split sentence #" "))))

;; Problem-solving approach:
;; 1. Split the input string into individual words using space as delimiter
;; 2. Reverse the order of the words (not the characters within words)
;; 3. Join the reversed word sequence back into a single string with spaces
;;
;; Key functions used:
;; - clojure.string/split: breaks string into vector of words at spaces (#" " regex)
;; - reverse: reverses the order of elements in the word vector
;; - clojure.string/join: combines words back into string with " " separator
;;
;; Example walkthrough:
;; (reverse-words "hello world!")
;; 1. split: "hello world!" -> ["hello" "world!"]
;; 2. reverse: ["hello" "world!"] -> ["world!" "hello"]
;; 3. join: ["world!" "hello"] -> "world! hello"

; test
; execute implement function
(defn tester [arg exp]
  (= (reverse-words arg) exp))

; args & exception
(comment
  (tester "hello world!" "world! hello")
  (tester "yoda doesn't speak like this" "this like speak doesn't yoda")
  (tester "foobar" "foobar")
  (tester "kata editor" "editor kata")
  (tester "row row row your boat" "boat your row row row"))
