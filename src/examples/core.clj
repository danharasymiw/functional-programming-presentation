(ns examples.core)

; We're given a string with a bunch of names that we want to tidy up.)
; The goal of this program is to do the following:)
; - 1. Not everything in the string is a name and those need to be removed,)
;      to keep it simple we'll consider anything 1 character long, to be not a name.)
; - 2. None of the names are capitalized, they should be. ("dan" -> "Dan"))
; - 3. Comma separate the names to make it nicer to read.)
(def bad-names  "dan % tom dave kelly 1 jim james bob nick z kyle max")

; This is what our solution should return to us.
(def answer "Dan, Tom, Dave, Kelly, Jim, James, Bob, Nick, Kyle, Max")

(defn is-name? [word]
      "Determines whether or not the given word is a name (it's greater than one character)"
      (< 1 (count word))) ; is 1 less than the number of characters in the word?


(defn solve [bad-names]
      ; The ->> macro is going to take the result from each line, and pass it in as
      ; the last argument to the function on the line below it
      (->> (clojure.string/split bad-names #" ") ; Split the string up into a list of words
           (filter is-name?) ; Remove everything that doesn't return true when passed as an argument to the is-name? function
           (map clojure.string/capitalize) ; Capitalize the first letter of everything we have, and store it in a new list
           (clojure.string/join ", "))) ; Join our list of words back together, seperated by a ", "

(println (solve bad-names)) ; Call our function, and print the results!

