# Exercism Exercises

[exercism.io](http://exercism.io) has been very useful for learning Clojure so far.
They are not excessively difficult, like the ones in [Ruby Quiz](http://rubyquiz.com)
(which are great btw).

Given the fact that each exercise comes with unit tests and that I'm
used to TDD, I added the `humane-test-output` dependency and
`lein-auto` plugin to each exercise for improved developer experience.

Inside each exercise root folder, run `lein auto test` to watch files
and re-run tests automatically.
