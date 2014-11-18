# Embed Clojure

A template project demonstrating embedding clojure as a scripting environment inside
a java host.

## Compile

Compile  `EvalClojure` and with `clojure.jar` (and optionally other 
required jars) on the `CLASSPATH`.

        javac -cp $HOME/.m2/repository/org/clojure/clojure/1.6.0/clojure-1.6.0.jar EvalClojure.java
        java EvalClojure


Look at [EvalClojure.java][4] for usage examples. 

## Update!!

Since clojure 1.6, there is a better way to communicate with clojure, namely, through `clojure.java.api.Clojure` interface.
Read [this stackoverflow post][5] and [java api documentation][6].


[1]: http://blog.jayfields.com/2011/12/clojure-java-interop.html
[2]: http://stackoverflow.com/questions/7708402/passing-objects-from-java-to-a-clojure-eval
[3]: http://stackoverflow.com/questions/14987910/java-clojure-java
[4]: https://github.com/alesk/embed-clojure/blob/master/EvalClojure.java#L23
[5]: http://stackoverflow.com/questions/2181774/calling-clojure-from-java/23555959#23555959
[6]: http://clojure.github.io/clojure/javadoc/clojure/java/api/package-summary.html
