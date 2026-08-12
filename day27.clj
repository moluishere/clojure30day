
; Create a function that returns the name of the winner in a fight between two fighters.
;
; Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
;
; Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
;
; Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.
;
; Your function also receives a third argument, a string, with the name of the fighter that attacks first.
;
; Example:
; declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"
;
; Lew attacks Harry; Harry now has 3 health.
; Harry attacks Lew; Lew now has 6 health.
; Lew attacks Harry; Harry now has 1 health.
; Harry attacks Lew; Lew now has 2 health.
; Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
; Technical note: The second fighter argument (f2) always attacks first.

; keywords: Math/ceil, if, let
; Key functions used:
; - Math/ceil: rounds up to calculate number of attacks needed to win
; - let: binds the number of attacks each fighter needs
; - if: determines the winner based on who needs fewer attacks

; implement
(defn declare-winner [f1 f2]
  (let [attacks-f1-needs (Math/ceil (/ (:health f2) (:damage-per-attack f1)))
        attacks-f2-needs (Math/ceil (/ (:health f1) (:damage-per-attack f2)))]
    (if (<= attacks-f1-needs attacks-f2-needs)
      (:name f1)
      (:name f2))))

; test
; execute implement function
(defn tester [f1 f2 exp]
  (= (declare-winner f1 f2) exp))

; args & exception
(comment
  (tester {:name "Harald" :health 20 :damage-per-attack 5} {:name "Harry" :health 5 :damage-per-attack 4} "Harald")
  (tester {:name "Jerry" :health 30 :damage-per-attack 3} {:name "Harald" :health 20 :damage-per-attack 5} "Harald"))
