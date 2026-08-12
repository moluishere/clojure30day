; so hard....it's a math questions. :(

; Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer.
;
; Square all numbers k (0 <= k <= n) between 0 and n.
;
; Count the numbers of digits d used in the writing of all the k**2.
;
; Call nb_dig (or nbDig or ...) the function taking n and d as parameters and returning this count.
;
; Examples:
; n = 10, d = 1
; the k*k are 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
; We are using the digit 1 in: 1, 16, 81, 100. The total count is then 4.
;
; nb_dig(25, 1) returns 11 since
; the k*k that contain the digit 1 are:
; 1, 16, 81, 100, 121, 144, 169, 196, 361, 441.
; So there are 11 digits 1 for the squares of numbers between 0 and 25.
; Note that 121 has twice the digit 1.

; Keywords: mathematical computation, digit counting, squares, range, string conversion, frequency

; implement
(defn nb-dig [n d]
  (let [squares (map #(* % %) (range (inc n)))           ; Step 1: Create squares 0² to n²
        square-strings (map str squares)                  ; Step 2: Convert to strings
        target-digit (str d)                              ; Step 3: Convert target digit to string
        all-digits (apply str square-strings)]            ; Step 4: Join all squares into one big string
    (count (filter #(= % target-digit) all-digits))))    ; Step 5: Count occurrences of target digit

;; Problem-solving approach (beginner-friendly breakdown):
;; 1. Generate all numbers from 0 to n using (range (inc n))
;;    - range creates [0 1 2 ... n], inc n because range is exclusive of end
;; 2. Square each number using (map #(* % %) ...)
;;    - #(* % %) is a shorthand function that multiplies a number by itself
;;    - map applies this function to every number in the range
;; 3. Convert each square to a string using (map str squares)
;;    - This lets us examine individual digits later
;; 4. Convert target digit d to string for comparison
;; 5. Join all square strings into one big string with (apply str ...)
;;    - This creates one long string like "014916253649648100"
;; 6. Filter and count occurrences of target digit
;;    - filter keeps only characters that match our target digit
;;    - count tells us how many matches we found
;;
;; Beginner concepts used:
;; - range: creates a sequence of numbers
;; - inc: adds 1 (because range excludes the end number)
;; - map: applies a function to every item in a collection
;; - #(* % %): anonymous function shorthand for squaring
;; - str: converts numbers to strings
;; - apply: applies a function to all items (here, joins strings)
;; - filter: keeps only items that match a condition
;; - let: creates local variables for cleaner code
;;
;; Example walkthrough with n=5, d=1:
;; 1. range: [0 1 2 3 4 5]
;; 2. squares: [0 1 4 9 16 25] (each number squared)
;; 3. strings: ["0" "1" "4" "9" "16" "25"]
;; 4. joined: "014916925" (all strings concatenated)
;; 5. filter for "1": finds "1" in positions for 1, 16
;; 6. count: 2 (the digit 1 appears twice total)

; test
; execute implement function
(defn tester [n d exp]
  (= (nb-dig n d) exp))

; args & exceptio
(comment
  (tester 10 1 4)      ; squares: 0,1,4,9,16,25,36,49,64,81,100 -> digit 1 appears in: 1,16,81,100 = 4 times
  (tester 25 1 11)     ; as described in problem: 11 occurrences of digit 1
  (tester 5750 0 4700) ; test case from original
  (tester 11011 2 9481) ; test case from original
  (tester 12224 8 7733) ; test case from original
  (tester 11549 1 11905)) ; test case from original
