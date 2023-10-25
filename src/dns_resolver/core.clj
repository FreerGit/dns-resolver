(ns dns-resolver.core
  (:gen-class)
  (:require [aleph.udp :as udp]
            [clj-commons.byte-streams :as bs]
            [manifold.deferred :as d]
            [manifold.stream :as s]))


(defn parse-message [{:keys [message]}]
  (do (println " xx?? ")
      (bs/print-bytes message)

      (println " ?? ")))


(defn start-statsd-server
  [server-port]
  (while true
    (let [server-socket @(udp/socket {:port server-port})]
      (do
        (println " before ")
        (println " 1 ")
        (println @(s/consume parse-message server-socket))
        (println "lastly")
        (s/drained? server-socket)))))


(def server (start-statsd-server 9999))

(do (println " t ")
    (println " t ")
    (println " t ")
    (println " t "))



;; (s/close! server)"

;; @(udp/socket {:port 9999})