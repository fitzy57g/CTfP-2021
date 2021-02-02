(ns core
  (:require [clojure.test :refer [are deftest run-tests]]))

;; 1.4.1
;; Implement, as best as you can, the identity function in your favorite language 
;; (or the second favorite, if your favorite language happens to be Haskell) .
(defn id [x] x)

;; 1.4.2
;; Implement the composition function in your favorite language.
;; It takes two functions as arguments and returns a function that is their composition.
(defn g-after-f [f g] (fn [x] (g (f x))))

;; 1.4.3
;; Write a program that tries to test that your composition function respects identity.
(deftest g-after-f-test
  (are [x y] (= x y)
    5 ((g-after-f id id) 5)
    10 ((g-after-f id #(* % 2)) 5)
    ((comp id #(* % 2)) 5) ((g-after-f id #(* % 2)) 5)))

(run-tests 'core)
