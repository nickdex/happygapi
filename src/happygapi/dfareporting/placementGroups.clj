(ns happygapi.dfareporting.placementGroups
  "Campaign Manager 360 API: placementGroups.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one placement group by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placementGroups/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :value string,
                                      :kind string,
                                      :matchType string,
                                      :id string,
                                      :etag string},
   :accountId string}
  
  Inserts a new placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placementGroups"
     #{:profileId}
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :value string,
                                      :kind string,
                                      :matchType string,
                                      :id string,
                                      :etag string},
   :accountId string}
  
  Updates an existing placement group. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placementGroups"
     #{:id :profileId}
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, placementGroupType, pageToken, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, placementStrategyIds, directorySiteIds, maxStartDate, maxResults, siteIds
  
  Retrieves a list of placement groups, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placementGroups"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placementGroups/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :value string,
                                      :kind string,
                                      :matchType string,
                                      :id string,
                                      :etag string},
   :accountId string}
  
  Updates an existing placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placementGroups"
     #{:profileId}
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
