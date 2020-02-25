(ns happygapi.firebaserules.projects
  "Firebase Rules API
  Creates and manages rules that determine when a Firebase Rules-enabled service should permit a request.
  
  See: https://firebase.google.com/docs/storage/security"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "firebaserules_schema.edn"))))

(defn test$
  "Required parameters: name
  
  Optional parameters: none
  
  Test `Source` for syntactic and semantic correctness. Issues present, if
  any, will be returned to the caller with a description, severity, and
  source location.
  
  The test method may be executed with `Source` or a `Ruleset` name.
  Passing `Source` is useful for unit testing new rules. Passing a `Ruleset`
  name is useful for regression testing an existing rule.
  
  The following is an example of `Source` that permits users to upload images
  to a bucket bearing their user id and matching the correct metadata:
  
  _*Example*_
  
      // Users are allowed to subscribe and unsubscribe to the blog.
      service firebase.storage {
        match /users/{userId}/images/{imageName} {
            allow write: if userId == request.auth.uid
                && (imageName.matches('*.png$')
                || imageName.matches('*.jpg$'))
                && resource.mimeType.matches('^image/')
        }
      }"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}:test"
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

(defn rulesets-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete a `Ruleset` by resource name.
  
  If the `Ruleset` is referenced by a `Release` the operation will fail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rulesets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Get a `Ruleset` by name including the full `Source` contents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rulesets-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  List `Ruleset` metadata only and optionally filter the results by `Ruleset`
  name.
  
  The full `Source` contents of a `Ruleset` may be retrieved with
  GetRuleset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}/rulesets"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rulesets-create$
  "Required parameters: name
  
  Optional parameters: none
  
  Create a `Ruleset` from `Source`.
  
  The `Ruleset` is given a unique generated name which is returned to the
  caller. `Source` containing syntactic or semantics errors will result in an
  error response indicating the first error encountered. For a detailed view
  of `Source` issues, use TestRuleset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}/rulesets"
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

(defn releases-getExecutable$
  "Required parameters: name
  
  Optional parameters: executableVersion
  
  Get the `Release` executable to use when enforcing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}:getExecutable"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn releases-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete a `Release` by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn releases-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  List the `Release` values for a project. This list may optionally be
  filtered by `Release` name, `Ruleset` name, `TestSuite` name, or any
  combination thereof."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}/releases"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn releases-create$
  "Required parameters: name
  
  Optional parameters: none
  
  Create a `Release`.
  
  Release names should reflect the developer's deployment practices. For
  example, the release name may include the environment name, application
  name, application version, or any other name meaningful to the developer.
  Once a `Release` refers to a `Ruleset`, the rules can be enforced by
  Firebase Rules-enabled services.
  
  More than one `Release` may be 'live' concurrently. Consider the following
  three `Release` names for `projects/foo` and the `Ruleset` to which they
  refer.
  
  Release Name                    | Ruleset Name
  --------------------------------|-------------
  projects/foo/releases/prod      | projects/foo/rulesets/uuid123
  projects/foo/releases/prod/beta | projects/foo/rulesets/uuid123
  projects/foo/releases/prod/v23  | projects/foo/rulesets/uuid456
  
  The table reflects the `Ruleset` rollout in progress. The `prod` and
  `prod/beta` releases refer to the same `Ruleset`. However, `prod/v23`
  refers to a new `Ruleset`. The `Ruleset` reference for a `Release` may be
  updated using the UpdateRelease method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}/releases"
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

(defn releases-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Get a `Release` by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn releases-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Update a `Release` via PATCH.
  
  Only updates to the `ruleset_name` and `test_suite_name` fields will be
  honored. `Release` rename is not supported. To create a `Release` use the
  CreateRelease method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaserules.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
