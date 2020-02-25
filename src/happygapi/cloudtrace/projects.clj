(ns happygapi.cloudtrace.projects
  "Stackdriver Trace API
  Sends application trace data to Stackdriver Trace for viewing. Trace data is collected for all App Engine applications by default. Trace data from other applications can be provided using this API. This library is used to interact with the Trace API directly. If you are looking to instrument your application for Stackdriver Trace, we recommend using OpenCensus.
  
  See: https://cloud.google.com/trace"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudtrace_schema.edn"))))

(defn traces-batchWrite$
  "Required parameters: name
  
  Optional parameters: none
  
  Sends new spans to new or existing traces. You cannot update
  existing spans.
  In this case, writing traces is not considered an active developer
  method since traces are machine generated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/trace.append"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtrace.googleapis.com/"
     "v2/{+name}/traces:batchWrite"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn traces-spans-createSpan$
  "Required parameters: name
  
  Optional parameters: none
  
  Creates a new span.
  In this case, writing traces is not considered an active developer
  method since traces are machine generated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/trace.append"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtrace.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
