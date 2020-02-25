(ns happygapi.storage.objects
  "Cloud Storage JSON API
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "storage_schema.edn"))))

(defn compose$
  "Required parameters: destinationBucket, destinationObject
  
  Optional parameters: destinationPredefinedAcl, ifGenerationMatch, ifMetagenerationMatch, kmsKeyName, provisionalUserProject, userProject
  
  Concatenates a list of existing objects into a new object in the same bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"destinationBucket" "destinationObject"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{destinationBucket}/o/{destinationObject}/compose"
     #{"destinationBucket" "destinationObject"}
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

(defn watchAll$
  "Required parameters: bucket
  
  Optional parameters: prefix, pageToken, delimiter, userProject, includeTrailingDelimiter, provisionalUserProject, versions, projection, maxResults
  
  Watch for changes on all objects in a bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/watch"
     #{"bucket"}
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

(defn get$
  "Required parameters: object, bucket
  
  Optional parameters: generation, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Retrieves an object or its metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn copy$
  "Required parameters: destinationBucket, sourceBucket, destinationObject, sourceObject
  
  Optional parameters: ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, destinationPredefinedAcl, userProject, provisionalUserProject, ifSourceMetagenerationNotMatch, sourceGeneration, ifSourceGenerationMatch, projection, ifSourceGenerationNotMatch, ifSourceMetagenerationMatch
  
  Copies a source object to a destination object. Optionally overrides metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"destinationBucket"
            "destinationObject"
            "sourceBucket"
            "sourceObject"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{sourceBucket}/o/{sourceObject}/copyTo/b/{destinationBucket}/o/{destinationObject}"
     #{"destinationBucket"
       "destinationObject"
       "sourceBucket"
       "sourceObject"}
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

(defn setIamPolicy$
  "Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Updates an IAM policy for the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: bucket
  
  Optional parameters: contentEncoding, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, name, ifGenerationNotMatch, ifMetagenerationMatch, kmsKeyName, userProject, provisionalUserProject, projection
  
  Stores a new object and metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o"
     #{"bucket"}
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

(defn patch$
  "Required parameters: object, bucket
  
  Optional parameters: generation, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Patches an object's metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "Required parameters: bucket, object, permissions
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Tests a set of permissions on the given object to see which, if any, are held by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"permissions" "object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam/testPermissions"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: object, bucket
  
  Optional parameters: generation, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Updates an object's metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: object, bucket
  
  Optional parameters: generation, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject
  
  Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for the bucket, or if the generation parameter is used."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Returns an IAM policy for the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: bucket
  
  Optional parameters: prefix, pageToken, delimiter, userProject, includeTrailingDelimiter, provisionalUserProject, versions, projection, maxResults
  
  Retrieves a list of objects matching the criteria."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o"
     #{"bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rewrite$
  "Required parameters: destinationBucket, sourceBucket, destinationObject, sourceObject
  
  Optional parameters: ifGenerationMatch, maxBytesRewrittenPerCall, ifMetagenerationNotMatch, rewriteToken, ifGenerationNotMatch, ifMetagenerationMatch, destinationPredefinedAcl, userProject, provisionalUserProject, ifSourceMetagenerationNotMatch, destinationKmsKeyName, sourceGeneration, ifSourceGenerationMatch, projection, ifSourceGenerationNotMatch, ifSourceMetagenerationMatch
  
  Rewrites a source object to a destination object. Optionally overrides metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"destinationBucket"
            "destinationObject"
            "sourceBucket"
            "sourceObject"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{sourceBucket}/o/{sourceObject}/rewriteTo/b/{destinationBucket}/o/{destinationObject}"
     #{"destinationBucket"
       "destinationObject"
       "sourceBucket"
       "sourceObject"}
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
