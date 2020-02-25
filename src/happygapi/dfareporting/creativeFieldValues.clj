(ns happygapi.dfareporting.creativeFieldValues
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "dfareporting_schema.edn"))))

(defn delete$
  "Required parameters: creativeFieldId, id, profileId
  
  Optional parameters: none
  
  Deletes an existing creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"creativeFieldId" "id" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues/{id}"
     #{"creativeFieldId" "id" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: creativeFieldId, id, profileId
  
  Optional parameters: none
  
  Gets one creative field value by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"creativeFieldId" "id" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues/{id}"
     #{"creativeFieldId" "id" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: creativeFieldId, profileId
  
  Optional parameters: none
  
  Inserts a new creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"creativeFieldId" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues"
     #{"creativeFieldId" "profileId"}
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

(defn list$
  "Required parameters: creativeFieldId, profileId
  
  Optional parameters: ids, maxResults, pageToken, searchString, sortField, sortOrder
  
  Retrieves a list of creative field values, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"creativeFieldId" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues"
     #{"creativeFieldId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: creativeFieldId, id, profileId
  
  Optional parameters: none
  
  Updates an existing creative field value. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"creativeFieldId" "id" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues"
     #{"creativeFieldId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: creativeFieldId, profileId
  
  Optional parameters: none
  
  Updates an existing creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"creativeFieldId" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeFields/{creativeFieldId}/creativeFieldValues"
     #{"creativeFieldId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
