(ns happygapi.admin.activities
  "Admin Reports API
  Fetches reports for the administrators of G Suite customers about the usage, collaboration, security, and risk for their users.
  See: /admin-sdk/reports/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "admin_schema.edn"))))

(defn list$
  "Required parameters: applicationName, userKey
  
  Optional parameters: eventName, actorIpAddress, startTime, filters, endTime, orgUnitID, pageToken, customerId, maxResults
  
  Retrieves a list of activities for a specific customer's account and application such as the Admin console application or the Google Drive application. For more information, see the guides for administrator and Google Drive activity reports. For more information about the activity report's parameters, see the activity parameters reference guides."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationName" "userKey"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "activity/users/{userKey}/applications/{applicationName}"
     #{"applicationName" "userKey"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "Required parameters: applicationName, userKey
  
  Optional parameters: eventName, actorIpAddress, startTime, filters, endTime, orgUnitID, pageToken, customerId, maxResults
  
  Start receiving notifications for account activities. For more information, see Receiving Push Notifications."
  {:scopes ["https://www.googleapis.com/auth/admin.reports.audit.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"applicationName" "userKey"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/admin/reports/v1/"
     "activity/users/{userKey}/applications/{applicationName}/watch"
     #{"applicationName" "userKey"}
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
