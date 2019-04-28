(ns user
  (:require [integrant.repl :refer [clear go halt init reset reset-all prep]]
            [integrant.core :as ig]
            [environ.core :as env]))

;; assumes you have a config.edn file with your Integrant components
;; in the root of your working directory
(integrant.repl/set-prep! (constantly (ig/read-string (slurp "config.edn"))))
