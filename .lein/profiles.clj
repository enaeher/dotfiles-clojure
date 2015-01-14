{:user
 {:dependencies [[pjstadig/humane-test-output "0.6.0"]
                 [io.aviso/pretty "0.1.8"]
                 [alembic "0.3.2"]
                 [acyclic/squiggly-clojure "0.1.2-SNAPSHOT"]
                 [org.clojure/tools.nrepl "0.2.7"]
                 [enaeher/contrail "0.2.0"]
                 [slamhound "1.5.5"]]
  :injections [(require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]
  :plugins [[cider/cider-nrepl "0.9.0"]
            [refactor-nrepl "1.1.0-SNAPSHOT"]
            [lein-kibit "0.0.8"]
            [lein-environ "1.0.0"]
            [jonase/eastwood "0.2.1" :exclusions [org.clojure/clojure]]
            [thunknyc/nrepl-profile "0.1.0-SNAPSHOT"]
            [com.palletops/lein-shorthand "0.4.0"]
            [lein-ancient "0.6.7"]]
  :shorthand {e [clojure.pprint/pprint
                 contrail.core/trace
                 contrail.core/untrace
                 contrail.core/all-traced
                 contrail.core/traced?]}
  :jvm-opts ["-XX:MaxJavaStackTraceDepth=100000" "-XX:-OmitStackTraceInFastThrow"]
  :aliases {"slamhound" ["run" "-m" "slam.hound"]}
  :env {:squiggly {:checkers [:kibit]}}}}
