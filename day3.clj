; Given a sequence of items and a specific item in that sequence, return the
; item immediately following the item specified. If the item occurs more than
; once in a sequence, return the item after the first occurence. This should
; work for a sequence of any type.
;
; When the item isn't present or nothing follows it, the function should return
; nil in Clojure and Elixir, Nothing in Haskell, undefined in JavaScript, None
; in Python.
;
; (next-item (range 1 10000) 7) ;=> 8
; (next-item ["Joe" "Bob" "Sally"] "Bob") ;=> "Sally"


; test
; (ns lazy-next-test
;             [lazy-next :refer [next-item]])
;
; (deftest SampleTests
;   (is (= (next-item (range 1 25) 12) 13))
;   (is (= (next-item "testing" \t) \e))
;   (is (nil? (next-item [:a :b :c] :d)))

; keywords: not-empty / second / rest
(defn next-item [input target]
  (if (not-empty input)
    (if (= target (first input))
      (second input)
      (next-item (rest input) target))
    nil))

 ; test
(defn tester [input target exp]
 (= (next-item input target) exp))
(comment
  (tester (range 1 25) 12 13)
  (tester "testing" \t \e)
  (tester [:a :b :c] :d nil)
  (tester [:a :b :c] :c nil)) (is (nil? (next-item [:a :b :c] :c)))

; Other Answers

; (defn next-item
;   "Returns the value that comes after item in xs or nil"
;   ([xs item])
;   (second (drop-while (complement #{item}) xs)))

; (defn next-item [xs item]
;    (when (not-empty xs)
;        (if (= item (first xs)
;             (second xs)
;             (next-item (rest xs) item)))))
