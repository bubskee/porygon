(ns porygon.poke-spec
  (:require [clojure.spec.alpha :as s]))

(s/valid? ::pokemon {:number 2
                     :primary-type :grass
                     :secondary-type :poison
                     :name "ivysaur"})

(s/def ::pokemon (s/keys :req-un [:pokemon/number
                                  :pokemon/primary-type
                                  :pokemon/name]
                         :opt-un [:pokemon/secondary-type]))

(s/def :pokemon/number int?)

(s/def :pokemon/name string?)

(s/def :pokemon/primary-type ::type)

(s/def :pokemon/secondary-type ::type)

(s/def ::type #{:poison
                       :grass
                       :electric
                       :fighting
                       :ice
                       :ground
                       :fairy
                       :fire
                       :dark
                       :water
                       :bug
                       :rock
                       :flying
                       :ghost
                       :dragon
                       :normal
                       :psychic
                       :steel})

(s/def :pokemon/legendary boolean?)

;; ---

(s/def ::combat-stat int?)
(s/def :pokemon/attack ::combat-stat)
(s/def :pokemon/defense ::combat-stat)
(s/def :pokemon/special-attack ::combat-stat)
(s/def :pokemon/special-defense ::combat-stat)
(s/def :pokemon/speed ::combat-stat)
(s/def :pokemon/hp ::combat-stat)


