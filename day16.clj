; My grandfather always predicted how old people would get, and right before he passed away he revealed his secret!
;
; In honor of my grandfather's memory we will write a function using his formula!
;
; Take a list of ages when each of your great-grandparent died.
; Multiply each number by itself.
; Add them all together.
; Take the square root of the result.
; Divide by two.
; Example
; predictAge(65, 60, 75, 55, 60, 63, 64, 45) === 86
; Note: the result should be rounded down to the nearest integer.
;
; Some random tests might fail due to a bug in the JavaScript implementation. Simply resubmit if that happens to you.

; implement
(defn predicter [ages]
  (->> ages           ; Start a thread-last pipeline with ages.
       (map #(* % %)) ; Square each age.
       (reduce +)     ; Sum all squared values.
       Math/sqrt      ; Take the square root. | Java class method
       (#(/ % 2.0))   ; Divide by 2.0 (using an anonymous fn to keep % as the dividend in ->>).
       Math/floor     ; Floor the result | Java class method
       int))          ; Cast to integer and return. | Java class method called by Clojure

; Tiny data flow (example input)
;
; [65 60 75 55 60 63 64 45]
; → L3: (4225 3600 5625 3025 3600 3969 4096 2025)
; → L4: 30165
; → L5: 173.595...
; → L6: 86.797...
; → L7: 86.0
; → L8: 86

; test
; execute implement function
(defn tester [arg exp]
  (= (predicter arg) exp))

; args & exception
(comment
  (tester [65 60 75 55 60 63 64 45] 86)
  (tester [32 54 76 65 34 63 64 45] 79))

; (defn predicter [ages]
;   (->> ages                   ; 開始 thread-last pipeline，把 ages 放進去
;        (map #(* % %))         ; 每個元素平方
;        (reduce +)             ; 把平方後的數字全部加總
;        Math/sqrt              ; 對總和開平方根 (Java 的 Math.sqrt)
;        (#(/ % 2.0))           ; 用匿名函數把結果除以 2.0，確保是浮點數除法
;        Math/floor             ; 向下取整 (Java 的 Math.floor)，回傳 double
;        int))                  ; 轉成整數
