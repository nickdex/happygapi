(ns happygapi.dfareporting.creatives
  "Campaign Manager 360 API: creatives.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :fsCommand {:top integer,
               :windowWidth integer,
               :positionOption string,
               :windowHeight integer,
               :left integer},
   :backupImageClickThroughUrl {:landingPageId string,
                                :customClickThroughUrl string,
                                :computedClickThroughUrl string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldValueId string,
                               :creativeFieldId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:rules [Rule], :defaultAssetId string},
   :adTagKeys [string],
   :obaIcon {:program string,
             :iconClickTrackingUrl string,
             :iconClickThroughUrl string,
             :resourceUrl string,
             :yPosition string,
             :iconViewTrackingUrl string,
             :size Size,
             :xPosition string},
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :name string,
                :eventName string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :value string,
                               :kind string,
                               :matchType string,
                               :id string,
                               :etag string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Updates an existing creative."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creatives"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives/list
  
  Required parameters: profileId
  
  Optional parameters: archived, studioCreativeId, campaignId, renderingIds, ids, searchString, types, pageToken, sortField, advertiserId, active, sortOrder, creativeFieldIds, companionCreativeIds, sizeIds, maxResults
  
  Retrieves a list of creatives, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creatives"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :fsCommand {:top integer,
               :windowWidth integer,
               :positionOption string,
               :windowHeight integer,
               :left integer},
   :backupImageClickThroughUrl {:landingPageId string,
                                :customClickThroughUrl string,
                                :computedClickThroughUrl string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldValueId string,
                               :creativeFieldId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:rules [Rule], :defaultAssetId string},
   :adTagKeys [string],
   :obaIcon {:program string,
             :iconClickTrackingUrl string,
             :iconClickThroughUrl string,
             :resourceUrl string,
             :yPosition string,
             :iconViewTrackingUrl string,
             :size Size,
             :xPosition string},
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :name string,
                :eventName string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :value string,
                               :kind string,
                               :matchType string,
                               :id string,
                               :etag string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Updates an existing creative. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creatives"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one creative by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creatives/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creatives/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :thirdPartyBackupImageImpressionsUrl string,
   :overrideCss string,
   :adParameters string,
   :skippable boolean,
   :allowScriptAccess boolean,
   :customKeyValues [string],
   :studioCreativeId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :fsCommand {:top integer,
               :windowWidth integer,
               :positionOption string,
               :windowHeight integer,
               :left integer},
   :backupImageClickThroughUrl {:landingPageId string,
                                :customClickThroughUrl string,
                                :computedClickThroughUrl string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :sslOverride boolean,
   :compatibility [string],
   :sslCompliant boolean,
   :skipOffset {:offsetPercentage integer, :offsetSeconds integer},
   :thirdPartyRichMediaImpressionsUrl string,
   :name string,
   :convertFlashToHtml5 boolean,
   :universalAdId {:registry string, :value string},
   :artworkType string,
   :authoringSource string,
   :type string,
   :creativeAssets [{:role string,
                     :fileSize string,
                     :idDimensionValue DimensionValue,
                     :additionalSizes [Size],
                     :windowMode string,
                     :bitRate integer,
                     :verticallyLocked boolean,
                     :offset OffsetPosition,
                     :horizontallyLocked boolean,
                     :sslCompliant boolean,
                     :positionLeftUnit string,
                     :frameRate number,
                     :alignment string,
                     :pushdownDuration number,
                     :artworkType string,
                     :zipFilesize string,
                     :childAssetType string,
                     :startTimeType string,
                     :orientation string,
                     :flashVersion integer,
                     :duration integer,
                     :streamingServingUrl string,
                     :audioSampleRate integer,
                     :displayType string,
                     :detectedFeatures [string],
                     :size Size,
                     :progressiveServingUrl string,
                     :originalBackup boolean,
                     :collapsedSize Size,
                     :durationType string,
                     :hideFlashObjects boolean,
                     :positionTopUnit string,
                     :active boolean,
                     :id string,
                     :customStartTimeValue integer,
                     :pushdown boolean,
                     :mimeType string,
                     :zIndex integer,
                     :position OffsetPosition,
                     :hideSelectionBoxes boolean,
                     :politeLoad boolean,
                     :expandedDimension Size,
                     :companionCreativeIds [string],
                     :zipFilename string,
                     :assetIdentifier CreativeAssetId,
                     :mediaDuration number,
                     :audioBitRate integer,
                     :actionScript3 boolean,
                     :transparency boolean,
                     :backupImageExit CreativeCustomEvent}],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :studioAdvertiserId string,
   :creativeFieldAssignments [{:creativeFieldValueId string,
                               :creativeFieldId string}],
   :thirdPartyUrls [{:thirdPartyUrlType string, :url string}],
   :commercialId string,
   :backupImageFeatures [string],
   :authoringTool string,
   :advertiserId string,
   :htmlCode string,
   :active boolean,
   :id string,
   :requiredFlashPluginVersion string,
   :kind string,
   :progressOffset {:offsetPercentage integer, :offsetSeconds integer},
   :creativeAssetSelection {:rules [Rule], :defaultAssetId string},
   :adTagKeys [string],
   :obaIcon {:program string,
             :iconClickTrackingUrl string,
             :iconClickThroughUrl string,
             :resourceUrl string,
             :yPosition string,
             :iconViewTrackingUrl string,
             :size Size,
             :xPosition string},
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :name string,
                :eventName string}],
   :lastModifiedInfo {:time string},
   :latestTraffickedCreativeId string,
   :totalFileSize string,
   :redirectUrl string,
   :requiredFlashVersion integer,
   :backupImageTargetWindow {:customHtml string,
                             :targetWindowOption string},
   :subaccountId string,
   :version integer,
   :dynamicAssetSelection boolean,
   :renderingIdDimensionValue {:dimensionName string,
                               :value string,
                               :kind string,
                               :matchType string,
                               :id string,
                               :etag string},
   :mediaDuration number,
   :autoAdvanceImages boolean,
   :backgroundColor string,
   :companionCreatives [string],
   :accountId string,
   :backupImageReportingLabel string,
   :studioTraffickedCreativeId string,
   :mediaDescription string,
   :htmlCodeLocked boolean,
   :renderingId string}
  
  Inserts a new creative."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creatives"
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
