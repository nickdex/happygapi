(ns happygapi.realtimebidding.buyers
  "Real-time Bidding API: buyers.
  Allows external bidders to manage their RTB integration with Google. This includes managing bidder endpoints, QPS quotas, configuring what ad inventory to receive via pretargeting, submitting creatives for verification, and accessing creative metadata such as approval status.
  See: https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists all buyer account information the calling buyer user or service account is permissioned to manage."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/buyers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a buyer account by its name."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRemarketingTag$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/getRemarketingTag
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets remarketing tag for a buyer. A remarketing tag is a piece of JavaScript code that can be placed on a web page. When a user visits a page containing a remarketing tag, Google adds the user to a user list."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:getRemarketingTag"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/creatives/list
  
  Required parameters: parent
  
  Optional parameters: view, filter, pageToken, pageSize
  
  Lists creatives."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/creatives/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a creative."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-patch$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/creatives/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:dealIds [string],
   :video {:videoVastXml string,
           :videoUrl string,
           :videoMetadata VideoMetadata},
   :creativeServingDecision {:detectedProductCategories [integer],
                             :detectedAdvertisers [AdvertiserAndBrand],
                             :chinaPolicyCompliance PolicyCompliance,
                             :networkPolicyCompliance PolicyCompliance,
                             :adTechnologyProviders AdTechnologyProviders,
                             :detectedClickThroughUrls [string],
                             :detectedSensitiveCategories [integer],
                             :dealsPolicyCompliance PolicyCompliance,
                             :russiaPolicyCompliance PolicyCompliance,
                             :detectedDomains [string],
                             :detectedLanguages [string],
                             :platformPolicyCompliance PolicyCompliance,
                             :detectedAttributes [string],
                             :lastStatusUpdate string,
                             :detectedVendorIds [integer]},
   :declaredVendorIds [integer],
   :declaredClickThroughUrls [string],
   :advertiserName string,
   :adChoicesDestinationUrl string,
   :name string,
   :impressionTrackingUrls [string],
   :apiUpdateTime string,
   :restrictedCategories [string],
   :creativeId string,
   :declaredAttributes [string],
   :native {:clickLinkUrl string,
            :headline string,
            :starRating number,
            :logo Image,
            :advertiserName string,
            :appIcon Image,
            :priceDisplayText string,
            :callToAction string,
            :clickTrackingUrl string,
            :videoUrl string,
            :videoVastXml string,
            :image Image,
            :body string},
   :creativeFormat string,
   :agencyId string,
   :declaredRestrictedCategories [string],
   :version integer,
   :accountId string,
   :html {:height integer, :snippet string, :width integer}}
  
  Updates a creative."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn creatives-create$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/creatives/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dealIds [string],
   :video {:videoVastXml string,
           :videoUrl string,
           :videoMetadata VideoMetadata},
   :creativeServingDecision {:detectedProductCategories [integer],
                             :detectedAdvertisers [AdvertiserAndBrand],
                             :chinaPolicyCompliance PolicyCompliance,
                             :networkPolicyCompliance PolicyCompliance,
                             :adTechnologyProviders AdTechnologyProviders,
                             :detectedClickThroughUrls [string],
                             :detectedSensitiveCategories [integer],
                             :dealsPolicyCompliance PolicyCompliance,
                             :russiaPolicyCompliance PolicyCompliance,
                             :detectedDomains [string],
                             :detectedLanguages [string],
                             :platformPolicyCompliance PolicyCompliance,
                             :detectedAttributes [string],
                             :lastStatusUpdate string,
                             :detectedVendorIds [integer]},
   :declaredVendorIds [integer],
   :declaredClickThroughUrls [string],
   :advertiserName string,
   :adChoicesDestinationUrl string,
   :name string,
   :impressionTrackingUrls [string],
   :apiUpdateTime string,
   :restrictedCategories [string],
   :creativeId string,
   :declaredAttributes [string],
   :native {:clickLinkUrl string,
            :headline string,
            :starRating number,
            :logo Image,
            :advertiserName string,
            :appIcon Image,
            :priceDisplayText string,
            :callToAction string,
            :clickTrackingUrl string,
            :videoUrl string,
            :videoVastXml string,
            :image Image,
            :body string},
   :creativeFormat string,
   :agencyId string,
   :declaredRestrictedCategories [string],
   :version integer,
   :accountId string,
   :html {:height integer, :snippet string, :width integer}}
  
  Creates a creative."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives"
     #{:parent}
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

(defn userLists-create$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:status string,
   :membershipDurationDays string,
   :urlRestriction {:endDate Date,
                    :url string,
                    :restrictionType string,
                    :startDate Date},
   :name string,
   :description string,
   :displayName string}
  
  Create a new user list."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/userLists"
     #{:parent}
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

(defn userLists-getRemarketingTag$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/getRemarketingTag
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets remarketing tag for a buyer. A remarketing tag is a piece of JavaScript code that can be placed on a web page. When a user visits a page containing a remarketing tag, Google adds the user to a user list."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:getRemarketingTag"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLists-open$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/open
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Change the status of a user list to OPEN. This allows new users to be added to the user list."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:open"
     #{:name}
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

(defn userLists-get$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a user list by its name."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLists-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the user lists visible to the current user."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/userLists"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLists-update$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:status string,
   :membershipDurationDays string,
   :urlRestriction {:endDate Date,
                    :url string,
                    :restrictionType string,
                    :startDate Date},
   :name string,
   :description string,
   :displayName string}
  
  Update the given user list. Only user lists with URLRestrictions can be updated."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn userLists-close$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/buyers/userLists/close
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Change the status of a user list to CLOSED. This prevents new users from being added to the user list."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+name}:close"
     #{:name}
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
