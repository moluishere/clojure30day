; Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.
;
; If you want to know more: http://en.wikipedia.org/wiki/DNA
;
; In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).
;
; More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)
;
; Example: (input --> output)
;
; "ATTGC" --> "TAACG"
; "GTAT" --> "CATA"

; Keywords: string operations, map, hash-map lookup, character manipulation, apply

; implement
(defn dna-strand [dna]
  (let [complements {\A \T \T \A \C \G \G \C}]
    (apply str (map complements dna))))

;; Problem-solving approach:
;; 1. Create a hash-map for base pair complements
;; 2. Map over each character in the DNA string using the hash-map as a function
;; 3. Convert the sequence of characters back to a string
;;
;; Key functions used:
;; - let: creates local binding for the complements hash-map
;; - map: applies hash-map lookup to each character in the string
;; - apply str: converts sequence of characters back to string
;; - hash-map as function: {\A \T} works as a lookup function
;;
;; DNA complement rules:
;; - Adenine (A) pairs with Thymine (T)
;; - Thymine (T) pairs with Adenine (A)
;; - Cytosine (C) pairs with Guanine (G)
;; - Guanine (G) pairs with Cytosine (C)
;;
;; Example walkthrough with "ATTGC":
;; 1. complements map: {\A \T \T \A \C \G \G \C}
;; 2. map processes each character: \A \T \T \G \C
;; 3. hash-map lookup: \A→\T, \T→\A, \T→\A, \G→\C, \C→\G
;; 4. apply str combines: (\T \A \A \C \G) → "TAACG"
;; 5. Result: "TAACG"
;;
;; Example walkthrough with "GTAT":
;; 1. complements map: {\A \T \T \A \C \G \G \C}
;; 2. map processes each character: \G \T \A \T
;; 3. hash-map lookup: \G→\C, \T→\A, \A→\T, \T→\A
;; 4. apply str combines: (\C \A \T \A) → "CATA"
;; 5. Result: "CATA"

; test
(defn tester [arg exp]
  (= (dna-strand arg) exp))

; args & exception
(comment
  (tester "ATTGC" "TAACG"))
  ; (tester "GTAT" "CATA")
  ; (tester "ATCG" "TAGC")
  ; (tester "AAAA" "TTTT")
  ; (tester "CCCC" "GGGG"))
