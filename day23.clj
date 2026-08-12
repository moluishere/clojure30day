; Definition
; Strong number is the number that the sum of the factorial of its digits is equal to number itself.
;
; For example, 145 is strong, since 1! + 4! + 5! = 1 + 24 + 120 = 145.
;
; Task
; Given a number, Find if it is Strong or not and return either "STRONG!!!!" or "Not Strong !!".

; implement
(defn strong [n]
  (let [factorial (fn [x]
                    (if (<= x 1)
                      1
                      (apply * (range 1 (inc x)))))
        factorial-sum (->> n
                           str
                           (map #(Integer/parseInt (str %)))
                           (map factorial)
                           (apply +))]
    (if (= n factorial-sum)
      "STRONG!!!!"
      "Not Strong !!")))

; test
; execute implement function
(defn tester [arg exp]
  (= (strong arg) exp))

; args & exception
(comment
  (tester 1 "STRONG!!!!")
  (tester 2 "STRONG!!!!")
  (tester 145 "STRONG!!!!")
  (tester 40585 "STRONG!!!!")
  (tester 7 "Not Strong !!")
  (tester 93 "Not Strong !!")
  (tester 185 "Not Strong !!"))


(defn strong [n]                                            ; 定義函式 `function`，參數是數字 n
  (let [
        factorial (fn [x]                                     ; 內部匿名函式：計算 x 的階乘
                    (if (<= x 1)                              ; 基底情況：0! 和 1! 都是 1
                      1
                      (apply * (range 1 (inc x)))))           ; 否則把 1..x 全部相乘；(range 1 (inc x)) 產生 [1 2 ... x]，(apply *) 將序列展開給 *

        factorial-sum (->> n                                  ; 用 thread-last（->>）把 n 一步步丟進後面的函式
                           str                                ; 先轉成字串，例如 145 -> "145"
                           (map #(Integer/parseInt (str %)))  ; 逐字元轉數字：(\1 \4 \5) -> (1 4 5)
                           (map factorial)                    ; 對每個位數做階乘：(1 4 5) -> (1! 4! 5!)
                           (apply +))]                        ; 將階乘結果加總：1!+4!+5!
    (if (= n factorial-sum)                                   ; 比對原數 n 是否等於位數階乘和
      "STRONG!!!!"                                            ; 相等：是 Strong number
      "Not Strong !!")))                                      ; 不相等：不是

