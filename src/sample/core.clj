(ns sample.core
  (:require [integrant.core :as ig]))

(defprotocol UserDatabase
  (get-user [db username])
  (create-user [db username password]))

(defrecord InMemoryDatabase [db]
  UserDatabase
  (get-user [_ username]
            (get @db username))
  (create-user [this username password]
               (swap! db assoc username {:password password})
               nil))

(defmethod ig/init-key :app/database [_ opts]
  (map->InMemoryDatabase opts))

(defmethod ig/init-key :database/state [_ _]
  (atom {}))

(defmethod ig/halt-key! :database/state [k db]
  (println "Halt" k))

; ==============================================================================
; System dev
(comment

  (def config
    (ig/read-string (slurp "config.edn")))

  (defn start-system! []
    (let [system (ig/init config)]
      system))

  (defn stop-system! [system]
    (ig/halt! system))

  (def system (start-system!))

  ; use example
  (create-user (:app/database system) "yolo" "123")
  (get-user (:app/database system) "yolo")
  (stop-system! system))
