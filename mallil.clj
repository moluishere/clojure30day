(def Address
  [:map
   [:id :string]
   [:tags [:set :keyword]]
   [:address
    [:map
     [:street :string]
     [:city :string]
     [:zip :int]
     [:lonlat [:tuple :double :double]]]]])

(prn Address)
; data structure:
; Address = {
;            :id     => String,
;            :tags   => Set of Keywords,
;            :address => {
;                         :street => String,
;                         :city   => String,
;                         :zip    => Int,
;                         :lonlat => [Double, Double]}} ; tuple: [longitude, latitude]

