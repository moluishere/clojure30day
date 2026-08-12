; Definition
; A Tidy number is a number whose digits are in non-decreasing order.
;
; Task
; Given a number, Find if it is Tidy or not .


; keywords: sort / mapv / Character/digit
; #(Character/digit % 10) => 把「字元」轉換成「整數」，第二個參數 10 表示「十進位」。
(defn tidy-number[number]
  (let [digits (mapv #(Character/digit % 10) (str number))]
    (= digits (sort digits))))

(defn tester [arg exp]
  (= (tidy-number arg) exp))

(comment
  (tester 12 true)
  (tester 102 false)
  (tester 9672 false)
  (tester 2789 true)
  (tester 2335 true))
