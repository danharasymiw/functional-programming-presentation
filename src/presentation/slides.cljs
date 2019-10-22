(ns presentation.slides)

(def intro
  [:section
   [:h1 "Functional Programming"]
   [:h3 "with Clojure"
    [:img {:src "img/clojure-logo.png"
           :style "margin: 0;
                   background: none;
                   border: none;
                   width: 1em;
                   max-height: 50%;
                   height: 1em;
                   padding-left: 0.25em;"}]]
   [:h6 "and Dan Harasymiw"]])

; TODO make a function for nested lists, might be a good example too

; Example of how data structures are trees and how copies aren't expensive to make

(def history
  [:section [:section
             [:h2 "Quick history of me and my experience (No Expert!)"]
             [:ul
              [:li "2012"]
              [:ul
               [:li "Introduced to functional programming languages (Scala?) in Programming Languages course in second year"]
               [:ul
                [:li "Seemed like a meme"]
                [:li "It looks weird. Kinda confusing. Why would I ever use this over “normal” languages?"]]]]]
   [:section
    [:ul [:li "2015"
          [:ul
           [:li "Graduated from Algoma University"]
           [:li "Hired on at Workiva"
            [:ul
             [:li "No sign of silly functional languages in insight"]]]]]]]
   [:section
    [:ul [:li "2018"
          [:ul
           [:li "Assigned to " [:a {:href "https://www.github.com/Workiva/eva"} "EVA"] " project"]
           [:ul
            [:li.fragment "Written in Clojure"]
            [:ul
             [:li.fragment "A Functional LISP Language"]
             [:ul
              [:li.fragment "Oh No"]]]]]]]]])

(def what-is-functional-programming
  [:section
   [:h2 "What is Functional Programming? (TLDR)"]
   [:ul
    [:li "Programs are made with functons"]
    [:ul
     [:li "Given certain inputs, you'll get certain outputs"]]
    [:li "Avoids changing state and mutating data"]
    [:li "Common characteristics of a functional language are:"]
    [:ul
     [:li "Immutability"]
     [:li "Higher Order Functions"]
     [:li "Laziness"]
     [:li "Purity and Referential Transparency"]]]])

; in java - strings are immutable, objects themselves are mutable (contents isn't)..i think?
(def immutability
  [:section
   [:section
    [:h2 "Immutability"]
    [:ul
     [:li "Cannot modify inputs to function"]
     [:li "Cannot modify sate outside of functions scope"]]]
   [:section
    [:h2 "Why is Mutability Harmful?"]
    [:pre
     [:code {:class "hljs java" :data-line-numbers "1,3,4" :data-trim true :data-noescape true}
      "
int " [:mark "x"] " = 5;
int doSomething(int y) {
  " [:mark "x"] " += 2;
  return " [:mark "x"] " + y;
}"]]]
   [:section {:data-background "img/forbids-it.png"}
    ""]
   ])

; TODO explain how a pure program can still do useful things

(def referential-transparency
  [:section
   [:h2 "Referential Transparency"]
   [:ul
    [:li "You can replace the call to a function with a value you would expect it to return"]
    [:ul
     [:li "This requires the function to be pure"]
     [:ul
      [:li "Given the same input, a function will always return the same output"]
      [:li "No side-effects! (ie. printing, displaying on screen, modifying a global var)"]]]]])

(def higher-order-functions
  [:section
   [:h2 "Higher Order Functions"]
   [:ul
    [:li "A function that can do one of, or both of the following:"]
    [:ul
     [:li "Take in a function as input"]
     [:li "Return a new function as output"]]
    [:li "Allows you to create a bunch of small distinct functions and combine them together (function composition)"]]])

; threading comparison perhaps?

(def laziness
  [:section
   [:section
    [:h2 "Lazy Evaluation"]
    [:ul
     [:li "Possible due to referential transparency"]
     [:li "Delays the evaluation of expressions until needed"]
     [:ul
      [:li "If the value isn't needed yet, why bother calculating it?"]]]]
   ; TODO too busy and would be good to have some examples
   ; actually, we could iframe repl.it examples perhaps instead of having to use the mac's repl
   [:section
    [:ul
     [:li "This allows for some cool things"]
     [:ul
      [:li "A list of infinite size (value not determined until accessed)"]
      [:li "Can be used powerfully with higher order functions"]
      [:ul
       [:li "A function that multiplies a number by itself"]
       [:li "A HOF that takes a list, a func, and applies that function to each element (map)"]
       [:li "Combining those two functions gives us back a list of all numbers to the power of 2, with no computation expended until we access one of the multiples"]]]]]])

; recursion / tail recursion? Why it's not inefficient?
; broader topic of BUT MAI LOOPS!

(def gif-slide
  [:section {:data-background "http://i.giphy.com/90F8aUepslB84.gif"}
   [:h2 "GIFS!"]])

(def iframe-slide
  [:section {:data-background-iframe "http://clojuredocs.org"}
   [:h2 "Interact with a Website!"]])

; this can easily be put up on a github pages and be used for the presentation

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [intro
   history
   what-is-functional-programming
   immutability
   referential-transparency
   higher-order-functions
   laziness
  ;  gif-slide
  ;  iframe-slide
   ])