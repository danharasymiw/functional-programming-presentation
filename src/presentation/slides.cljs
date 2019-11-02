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

(def history
  [:section [:section
             [:h2 "Quick history of me and my experience (No Expert!)"]
             [:ul
              [:li "2012"]
              [:ul
               [:li "Introduced to functional programming languages (lisp?) in Programming Languages course in second year"]
               [:ul
                [:li "Seemed like a meme"]
                [:li "It looks weird. Kinda confusing. Why would I ever use this over “normal” languages?"]]]]]
   [:section
    [:ul [:li "2015"
          [:ul
           [:li "Graduated from Algoma University"]
           [:li "Hired on at Workiva"
            [:ul
             [:li "No sign of silly functional languages in sight"]]]]]]]
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
   [:h3 "What is Functional Programming? (TLDR)"]
   [:ul
    [:li "Programs are made with functions"]
    [:ul
     [:li "Given certain inputs, you'll get certain outputs"]]
    [:li "Avoids changing state and mutating data"]
    [:li "Common characteristics of a functional language are:"]
    [:ul
     [:li "Immutability, higher order functions, laziness, and referential transparency"]]]])

(def immutability
  [:section
   [:section
    [:h3 "Immutability"]
    [:ul
     [:li "Cannot modify inputs to function"]
     [:li "Cannot modify state outside of functions scope"]]]
   [:section
    [:h3 "Why is Mutability Harmful?"]
    [:pre
     [:code {:class "hljs java" :data-line-numbers "1,3,4" :data-trim true :data-noescape true}
      "
int " [:mark "x"] " = 5;
int doSomething(int y) {
  " [:mark "x"] " += 2;
  return " [:mark "x"] " + y;
}"]]]])


(def referential-transparency
  [:section
   [:h3 "Referential Transparency"]
   [:ul
    [:li "You can replace the call to a function with the value you would expect it to return"]
    [:ul
     [:li "This requires the function to be pure"]
     [:ul
      [:li "Given the same input, a function will always return the same output"]
      [:li "No side-effects! (ie. modifying a global variable, printing to a screen)"]]]]])

(def higher-order-functions
  [:section
   [:h3 "Higher Order Functions"]
   [:ul
    [:li "A function that can do one of, or both of the following:"]
    [:ul
     [:li "Take in a function as input"]
     [:li "Return a new function as output"]]
    [:li "Allows you to create a bunch of small distinct functions and combine them together (function composition)"]]])

(def basics-of-clojure
  [:section
   [:section
    [:h3 "Basics of Clojure - Data Types"]
    [:ul
     [:li "Numbers - " [:code "1,2,3,4"] " (Java's Long)"]
     [:li "Floating Point - " [:code "1.23"] " (Java's Double)"]
     [:li "Ratios - " [:code "1/2,1/4,1/8"]]
     [:li "Strings - " [:code "\"Hello\""]]
     [:li "Characters - " [:code "#\"A\""]]
     [:li "Vectors - " [:code "[1 2 3]"] " (Commas are Optional)"]
     [:li "Lists - " [:code "(1 2 3)"]]
     [:li "Null - " [:code "nil"]]]]
   [:section
    [:h4 "Calling a function"]
    [:pre [:code {:class "hljs clojure" :data-trim true :data-noescape true} "(+ 1 2 3 4)"]]
    [:h4 "Creating a variable"]
    [:pre [:code {:class "hljs clojure" :data-trim true :data-noescape true} "(def fav-number 7)"]]]
   [:section
    [:h3 "Creating a function"]
    [:pre
     [:code {:class "hljs clojure" :data-trim true :data-noescape true}
      "
(defn add-numbers
  “A function that adds two numbers together”
  [x y]
  (+ x y))
"]]]])

(def laziness
  [:section
   [:section
    [:h3 "Lazy Evaluation"]
    [:ul
     [:li "Delays the evaluation of expressions until needed and is possible due to referential transparency"]
     [:ul
      [:li "If the value isn't needed yet, why bother calculating it?"]]
     [:li "This allows for some cool things..."]]]
   ; TODO too busy and would be good to have some examples
   ; actually, we could iframe repl.it examples perhaps instead of having to use the mac's repl
   [:section
    [:h3 "A list of infinite size (value not determined until accessed)"]
    [:pre
     [:code {:class "hljs clojure" :data-trim true :data-noescape true}
      "
(def infinite-list (repeat \"INFINITE\"))

(first infinite-list) ; => \"INFINITE\"

(take 3 infinite-list) ; => (\"INFINITE\" \"INFINITE\" \"INFINITE\")
"]]]])
;   [:section
;    [:h3 "Higher Order Function Example"]
;    [:pre
;     [:code {:class "hljs clojure" :data-trim true :data-noescape true}
;      "
;; Given a list of numbers, we'd like to square them all
;(def numbers '(1 2 3 4 5))
;
;; Create a function that squares the number
;(defn multiply-number [n]
;  (* n n))
;
;; Map that function onto the elements of the list
;; Where's the loop!?
;(map multiply-number numbers) ; => (1 4 9 16 25)
;"]]]


(def macros
  [:section
   [:section
    [:h3 "The code is data"]
    [:ul
     [:li "One common theme in LISP style languages is that at the end of the day the code is a list, data."]
     [:li "Well if the code is data, that means we can manipulate and extend it however we want"]
     [:li "If you don't like something about Clojure or want to add something, you actually can!"]]]
   [:section
    [:h3 "A simple macro"]
    [:p "A macro will, at compile-time, modify the code represented as a list and return it.  The possibilities are endless"]
    [:pre
     [:code {:class "hljs clojure" :data-trim true :data-noescape true}
      "
(defmacro infix
  \"Prefix notation got you down, here, take this!\"
  [infixed]
  (list (second infixed) (first infixed) (last infixed)))

(infix (1 + 1)) ; => 2

; Let's see what the macro generates
(macroexpand '(infix (1 + 1))) ; => (+ 1 1)
"]]]])

(def companies
  [:section
   [:section
    [:h3 "Companies that use Functional Languages"]
    [:ul
     [:li [:a {:href "https://blog.discordapp.com/scaling-elixir-f9b8e1e7c29b"} "How Discord Scaled Elixir to 5,000,000 Concurrent Users"]]
     [:li [:a {:href "https://engineering.fb.com/security/fighting-spam-with-haskell/"} "Facebook - Fighting spam with Haskell"]]
     [:li [:a {:href "http://blog.cognitect.com/blog/2015/6/30/walmart-runs-clojure-at-scale"} "Walmart Runs Clojure at Scale"]]
     [:li [:a {:href "https://blog.developer.atlassian.com/why-clojure/"} "Atlassian - Why you should use Clojure for your next microservice"]]
     [:li [:a {:href "https://www.salttoday.ca"} "SaltToday.ca uses Clojure to collect and rank SooToday's comments"]]]]])

(def resources
  [:section
   [:section
    [:h3 "A collection of resources on functional programming and Clojure"]
    [:ul
     [:li [:a {:href "https://www.braveclojure.com/clojure-for-the-brave-and-true/"} "Free beginner level Clojure book"]]
     [:li [:a {:href "http://clojuredocs.org/"} "Clojure documentation website"]]
     [:li [:a {:href "https://exercism.io/"} "Programming problems for various languages, offers mentorship feedback as well"]]
     [:li [:a {:href "http://learnyouahaskell.com/chapters"} "Free beginner level Haskell book"]]
     [:li [:a {:href "http://www.buildyourownlisp.com/contents"} "Free book on making your own LISP, compiler and all, in less than 1000 lines."]]]]])
   ;[:section
   ; [:h3 "Advent of Code"]
   ; [:img {:src "img/advent.jpg" :height "100%" :width "200px"}]
   ; [:p "The annual " [:a {:href "https://adventofcode.com/"} "Advent of Code"] " is approaching (month of December). Consider trying out a new functional language for some of the challenges"]
   ; [:p "Whether that be Clojure, Rust, Haskell, Elixir, Scala, etc or even using a conventional language like Java in a purely-functional style"]]


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
   companies
   what-is-functional-programming
   immutability
   referential-transparency

   laziness
   higher-order-functions
   basics-of-clojure
   macros
   resources])
  ;  gif-slide
  ;  iframe-slide
