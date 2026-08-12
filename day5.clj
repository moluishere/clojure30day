; After a hard quarter in the office you decide to get some rest on a vacation.
; So you will book a flight for you and your girlfriend and try to leave all
; the mess behind you.
;
; You will need a rental car in order for you to get around in your vacation.
; The manager of the car rental makes you some good offers.
;
; Every day you rent the car costs $40. If you rent the car for 7 or more days,
; you get $50 off your total. Alternatively, if you rent the car for 3 or more
; days, you get $20 off your total.
;
; Write a code that gives out the total amount for different days(d).


; Keywords used in this solution:
; let - creates local bindings for variables within its scope
; cond - evaluates conditions in order, returns value of first true condition
; >= - greater than or equal comparison function
; - - subtraction function
; :else - keyword used as default condition in cond (always evaluates to true)

(defn rental-car-cost [d]
  ;; Step 1: Calculate base cost using let binding
  (let [base (* d 40)]
    ;; Step 2: Apply discounts based on rental duration using cond
    (cond
      ;; Step 3a: Check for 7+ days discount ($50 off)
      (>= d 7) (- base 50)
      ;; Step 3b: Check for 3+ days discount ($20 off)
      (>= d 3) (- base 20)
      ;; Step 3c: Default case - no discount
      :else base)))

;test
(defn tester [act exp]
  (= (rental-car-cost act) exp))

(comment
  (tester 1 40)
  (tester 3 100)
  (tester 8 270))

; def 定義的變數可被重新綁定，但這樣做會增加狀態管理的複雜性。
;
; 如果你在函數裡寫 def，幾乎一定是錯誤設計，應該改用 let。
;
; Clojure 是函數式語言，提倡少用 def，多用 let 和 immutable data。
