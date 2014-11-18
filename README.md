# Embed Clojure

A template project demonstrating embed clojure as a scripting environment inside
a java host.

## Compile

Compile  `EvalClojure` and with `clojure.jar` (and optionally other 
required jars) on the `CLASSPATH`.

        javac -cp $HOME/.m2/repository/org/clojure/clojure/1.6.0/clojure-1.6.0.jar EvalClojure.java
        java EvalClojure



[1]: http://blog.jayfields.com/2011/12/clojure-java-interop.html
[2]: http://stackoverflow.com/questions/7708402/passing-objects-from-java-to-a-clojure-eval
[3]: http://stackoverflow.com/questions/14987910/java-clojure-java
