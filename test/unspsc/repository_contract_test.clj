(ns unspsc.repository-contract-test
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.test :refer [deftest is]]))

(deftest canonical-repository-shape
  (doseq [path ["manifest.edn" "identity.edn" "dependencies.edn"
                "repository-contracts.edn" "schema.edn"
                "lex/processManifest.edn"]]
    (is (some? (edn/read-string (slurp path))) path))
  (is (vector? (edn/read-string (slurp "schema.edn"))))
  (is (= 18342 (count (edn/read-string
                       (slurp "resources/unspsc-taxonomy.edn")))))
  (is (not (.exists (io/file "manifest.jsonld"))))
  (is (not (.exists (io/file "run_tests.sh"))))
  (is (.isFile (io/file "wire/lex/processManifest.json"))))
