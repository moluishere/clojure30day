; Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
;
; Write a function which takes a list of strings and returns each line prepended by the correct number.
;
; The numbering starts at 1. The format is n: string. Notice the colon and space in between.
;
; Examples: (Input --> Output)
;
; [] --> []
; ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]

; Keywords: string formatting, indexing, map-indexed, vector operations

; implement
(defn number [lines]
  (map-indexed (fn [idx line]
                 (str (inc idx) ": " line))
               lines))

;; Problem-solving approach:
;; 1. Use map-indexed to get both index and value for each line
;; 2. Add 1 to index since numbering starts at 1 (not 0)
;; 3. Format each line as "number: content"
;; 4. Return the transformed collection
;;
;; Key functions used:
;; - map-indexed: applies function to each element with its index
;; - inc: increments index by 1 (0-based to 1-based)
;; - str: concatenates strings to create formatted output
;;
;; Example walkthrough with ["a", "b", "c"]:
;; 1. map-indexed gets: (0 "a") (1 "b") (2 "c")
;; 2. inc idx: 1, 2, 3
;; 3. str formatting: "1: a", "2: b", "3: c"
;; 4. Result: ["1: a", "2: b", "3: c"]
;;
;; Example walkthrough with []:
;; 1. Empty collection returns empty collection
;; 2. Result: []

; test
; execute implement function
(defn tester [arg exp]
  (= (number arg) exp))

; args & exception
(comment
  (tester [] [])
  (tester ["a" "b" "c"] ["1: a" "2: b" "3: c"])
  (tester ["" "" "" "" ""] ["1: " "2: " "3: " "4: " "5: "])
  (tester ["Hello" "World"] ["1: Hello" "2: World"])
  (tester ["single line"] ["1: single line"]))
