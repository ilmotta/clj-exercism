(defproject grade-school "0.1.0-SNAPSHOT"
  :description "grade-school exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/grade-school"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [pjstadig/humane-test-output "0.8.1"]]
  :injections [(require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]
  :plugins [[lein-auto "0.1.3"]])
