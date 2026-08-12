; Complete the function/method so that it returns the url with anything after the anchor (#) removed.
;
; Examples
; "www.codewars.com#about" --> "www.codewars.com"
; "www.codewars.com?page=1" -->"www.codewars.com?page=1"

; Keywords: string manipulation, URL parsing, anchor removal, split, substring, regex

; implement
(defn remove-url-anchor [url]
  (first (clojure.string/split url #"#")))

;; Problem-solving approach:
;; 1. Split the URL string at the anchor symbol (#)
;; 2. Take only the first part (everything before the #)
;; 3. If no # exists, the original URL is returned unchanged
;;
;; Key functions used:
;; - clojure.string/split: splits string at # delimiter into vector
;; - first: takes the first element from the split result
;; - #"#": regex pattern that matches the anchor symbol
;;
;; Example walkthrough:
;; (remove-url-anchor "www.codewars.com#about")
;; 1. split: "www.codewars.com#about" -> ["www.codewars.com" "about"]
;; 2. first: ["www.codewars.com" "about"] -> "www.codewars.com"
;;
;; Edge case - no anchor:
;; (remove-url-anchor "www.codewars.com?page=1")
;; 1. split: "www.codewars.com?page=1" -> ["www.codewars.com?page=1"]
;; 2. first: ["www.codewars.com?page=1"] -> "www.codewars.com?page=1"

; test
; execute implement function
(defn tester [arg exp]
  (= (remove-url-anchor arg) exp))

; args & exception
(comment
  (tester "www.codewars.com#about" "www.codewars.com")
  (tester "www.codewars.com/katas/?page=1#about" "www.codewars.com/katas/?page=1")
  (tester "www.codewars.com/katas/" "www.codewars.com/katas/"))
