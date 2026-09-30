(ns user
  (:require
   [clojure.pprint]
   [cider.nrepl]
   [clojure.main]
   [nrepl.server]
   [sc.api]))

(alter-var-root #'*print-length* (constantly 50))
(alter-var-root #'*print-namespace-maps* (constantly false))
;(alter-var-root #'*warn-on-reflection* (constantly true))
(nrepl.server/start-server
 :socket "./nrepl-server"
 :handler cider.nrepl/cider-nrepl-handler)

;; Try to get any exceptions in any thread to show up in Emacs--note,
;; this requires some elisp code elsewhere

(defonce last-exception (atom nil))

(defn register-exception-for-cider [e]
  (reset! last-exception e)
  (binding [*out* *err*]
    (println "CIDER-EXCEPTION-SENTINEL")))

(Thread/setDefaultUncaughtExceptionHandler
 (reify Thread$UncaughtExceptionHandler
   (uncaughtException [_ _thread e]
     (register-exception-for-cider e))))

(alter-var-root
 #'clojure.main/report-error
 (fn [orig]
   (fn [e & opts]
     (register-exception-for-cider e)
     (apply orig e opts))))

;; Extent pretty-printer to treat Datomic entity maps like Clojure maps

(defmethod clojure.pprint/simple-dispatch datomic.Entity [e]
  ((get (methods clojure.pprint/simple-dispatch) clojure.lang.IPersistentMap)
   (merge (.cache e) (.edits e))))

(println "Evaluated user.clj")
