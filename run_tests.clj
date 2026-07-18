(require '[babashka.fs :as fs]
         '[babashka.process :as process])

(let [root (str (fs/parent (fs/absolutize *file*)))
      command ["clojure" "-X:test"]
      result (apply process/shell {:dir root} command)]
  (System/exit (:exit result)))
