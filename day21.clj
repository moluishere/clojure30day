; Complete the solution so that it splits the string into pairs of two characters.
; If the string contains an odd number of characters then it should replace the missing
; second character of the final pair with an underscore ('_').
;
; Examples:
;
; 'abc' => ['ab', 'c_']
; 'abcdef' => ['ab', 'cd', 'ef']

; Keywords: string manipulation, partitioning, padding, vector operations, regex

; implement
(defn solution [s]
  (let [padded-string (if (odd? (count s))
                        (str s "_")
                        s)]
    (->> padded-string
         (partition 2)
         (map #(apply str %)))))

;; Problem-solving approach:
;; 1. Check if string length is odd, if so add underscore to make it even
;; 2. Partition the string into pairs of 2 characters
;; 3. Convert each pair back to a string
;; 4. Return vector of string pairs
;;
;; Key functions used:
;; - count: gets length of string
;; - odd?: checks if number is odd
;; - str: concatenates strings (adds underscore if needed)
;; - partition: splits collection into groups of specified size
;; - map: applies function to each element
;; - apply str: joins characters in each pair back into strings
;; - ->>: threading macro for cleaner data transformation
;;
;; Example walkthrough with "abc":
;; 1. count "abc" = 3, which is odd
;; 2. padded-string = "abc_" (add underscore)
;; 3. partition 2: (\a \b) (\c \_)
;; 4. map apply str: ("ab" "c_")
;; 5. Result: ["ab" "c_"]
;;
;; Example walkthrough with "abcdef":
;; 1. count "abcdef" = 6, which is even
;; 2. padded-string = "abcdef" (no change needed)
;; 3. partition 2: (\a \b) (\c \d) (\e \f)
;; 4. map apply str: ("ab" "cd" "ef")
;; 5. Result: ["ab" "cd" "ef"]

; test
; execute implement function
(defn tester [arg exp]
  (= (solution arg) exp))

; args & exception
(comment
  (tester "abc" ["ab" "c_"])
  (tester "abcdef" ["ab" "cd" "ef"])
  (tester "" [])
  (tester "x" ["x_"])
  (tester "Banana" ["Ba" "na" "na"])
  (tester "CodeWars" ["Co" "de" "Wa" "rs"]))
