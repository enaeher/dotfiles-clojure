{:repl
 {:dependencies [;; [acyclic/squiggly-clojure "0.1.5"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [enaeher/contrail "0.2.0"]]
  :plugins [[cider/cider-nrepl "0.11.0"]
            [thunknyc/nrepl-profile "0.1.0-SNAPSHOT"]
            [refactor-nrepl "2.2.0-SNAPSHOT"]
            [lein-kibit "0.1.2"]
            [jonase/eastwood "0.2.1" :exclusions [org.clojure/clojure]]]
  ;; :env {:squiggly {:checkers [:kibit]}}
  }
 :user
 {:dependencies [[pjstadig/humane-test-output "0.6.0"]
                 [io.aviso/pretty "0.1.8"]
                 [slamhound "1.5.5"]]
  :shorthand {e [clojure.pprint/pprint
                 contrail.core/trace
                 contrail.core/untrace
                 contrail.core/all-traced
                 contrail.core/traced?]}
  :injections [(require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]
  :plugins [[com.jakemccrary/lein-test-refresh "0.11.0"]
            [lein-ancient "0.6.7"]
            [com.palletops/lein-shorthand "0.4.0"]]
  :jvm-opts ["-XX:MaxJavaStackTraceDepth=100000" "-XX:-OmitStackTraceInFastThrow"]
  :aliases {"slamhound" ["run" "-m" "slam.hound"]}}}
