(defproject integrant-sample "0.1.0-SNAPSHOT"
  :description "Play around with Integrant"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [integrant "0.7.0"]
                 [environ "1.1.0"]]
  :profiles {:dev {:dependencies [[integrant/repl "0.3.1"]]
                   :plugins [[lein-environ "1.1.0"]]
                   :source-paths ["dev/clj"]}})
