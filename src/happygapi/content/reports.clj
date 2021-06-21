(ns happygapi.content.reports
  "Content API for Shopping: reports.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/reports/search
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer, :query string}
  
  Retrieves merchant performance mertrics matching the search query and optionally segmented by selected dimensions."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/reports/search"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
