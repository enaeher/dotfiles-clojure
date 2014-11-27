{:user
 {:dependencies [[pjstadig/humane-test-output "0.6.0"]]
  :injections [(require 'pjstadig.humane-test-output)
               (pjstadig.humane-test-output/activate!)]
  :plugins [[cider/cider-nrepl "0.8.2-SNAPSHOT"]
            [refactor-nrepl "0.1.0"]]}}
