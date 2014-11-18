import clojure.lang.RT;
import clojure.lang.Var;
import clojure.lang.Symbol;
import clojure.lang.PersistentList;

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

                int[] arr = {1,2,3,4};
                def("a", (Object) arr);

                Map<String,Object> map = new HashMap<String, Object>();
                map.put("a", (Object) arr);
                map.put("c", (Object) "My String");
                def("o", (Object) map);

                readAndEval("(require 'clojure.string)");
                repl("(apply str user/a)");

                repl("(clojure.string/join \", \" (map #(* % %) user/a))");

                repl("(str (.get user/o \"c\"))");

                repl("(apply str (.get user/o \"a\"))");

                RT.load("foo");
                RT.loadResourceScript("foo.clj");
        }
} 
