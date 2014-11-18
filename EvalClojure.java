import clojure.lang.RT;
import clojure.lang.Var;
import clojure.lang.Symbol;
import clojure.lang.Compiler;
import clojure.lang.PersistentList;

import java.io.StringReader;
import java.util.Map;
import java.util.HashMap;

public class EvalClojure {

        // all relevant classes should be imported here


        private static Var eval = RT.var("clojure.core", "eval");

        public static Object readAndEval(String script) { return eval.invoke(RT.readString(script)); }
        public static void   repl(String script) { System.out.println((String) readAndEval(script)); }

        public static Object def(String nameSpace, String name, Object obj) { return RT.var(nameSpace, name, obj); }

        public static Object def(String name, Object obj) { return def("user", name, obj); }

        public static void main(String [] args) throws Exception {

                // add local array arr to clojure RT as user/a
                int[] arr = {1,2,3,4};
                def("a", (Object) arr);

                // add local hashmap to clojure RT as user/o
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("a", (Object) arr);
                map.put("c", (Object) "My String");
                def("o", (Object) map);

                // import clojure.string namespace
                readAndEval("(require 'clojure.string)");

                // print content of user/a
                repl("(apply str user/a)");

                // more engaging script
                repl("(clojure.string/join \", \" (map #(* % %) user/a))");

                //Compiler.load(readAndEval("(do (ns user)  (clojure.string/join \", \" (map #(* % %) a)))");
                //RT.pushThreadBindings(RT.mapUniqueKeys(RT.CURRENT_NS, Symbol.intern("user")));

                // get string from hashmap
                repl("(str (.get user/o \"c\"))");

                repl("(apply str (.get user/o \"a\"))");

                // load script (clj is attached automatically)
                RT.load("foo");

                // load script with full path name
                RT.loadResourceScript("foo.clj");

                // calling function from a script
                repl("(user/foo \"Hello\" \"World\")");
        }
} 
