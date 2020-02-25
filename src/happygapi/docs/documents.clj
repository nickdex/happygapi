(ns happygapi.docs.documents
  "Google Docs API
  Reads and writes Google Docs documents.
  See: https://developers.google.com/docs/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "docs_schema.edn"))))

(defn get$
  "Required parameters: documentId
  
  Optional parameters: suggestionsViewMode
  
  Gets the latest version of the specified document."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/documents.readonly"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"documentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents/{documentId}"
     #{"documentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a blank document using the title given in the request. Other fields
  in the request, including any provided content, are ignored.
  
  Returns the created document."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents"
     #{}
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

(defn batchUpdate$
  "Required parameters: documentId
  
  Optional parameters: none
  
  Applies one or more updates to the document.
  
  Each request is validated before
  being applied. If any request is not valid, then the entire request will
  fail and nothing will be applied.
  
  Some requests have replies to
  give you some information about how they are applied. Other requests do
  not need to return information; these each return an empty reply.
  The order of replies matches that of the requests.
  
  For example, suppose you call batchUpdate with four updates, and only the
  third one returns information. The response would have two empty replies,
  the reply to the third request, and another empty reply, in that order.
  
  Because other users may be editing the document, the document
  might not exactly reflect your changes: your changes may
  be altered with respect to collaborator changes. If there are no
  collaborators, the document should reflect your changes. In any case,
  the updates in your request are guaranteed to be applied together
  atomically."
  {:scopes ["https://www.googleapis.com/auth/documents"
            "https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"documentId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://docs.googleapis.com/"
     "v1/documents/{documentId}:batchUpdate"
     #{"documentId"}
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
