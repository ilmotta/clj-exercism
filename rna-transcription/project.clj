(defproject rna-transcription "0.1.0-SNAPSHOT"
  :description "rna-transcription exercise."
  :url "https://github.com/exercism/xclojure/tree/master/exercises/rna-transcription"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [pjstadig/humane-test-output "0.8.1"]]
  :injections [(require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]
  :plugins [[lein-auto "0.1.3"]])
