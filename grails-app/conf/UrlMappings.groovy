class UrlMappings {
  static mappings = {
//    "/$controller/$action?/$id?" {
//      constraints {
//        // apply constraints here
//      }
//    }
    
    "/validate/$registrationKey"(controller: "registrationValidation") {
    }

    "/register"(controller: "register") {
      action = [GET:"index", POST:"register"]
    }

    "/login"(controller: "login") {
      action = [GET:"index", POST:"submit"]

    }

    "/settings"(controller: "settings") {
      action = [GET:"index", POST:"register"]

    }

    "/text"(controller: "textCloud") {
      action = [PUT:"upload", POST:"upload"]
    }

    "/text/$key/$tag"(controller: "textCloud") {
      action = [GET: "loadTag"]
    }

    "/text/$key"(controller: "textCloud") {
      action = [GET: "loadCloud"]
    }

    "/"(controller:"home", view: "/index")

    "500"(view: '/error')
    "404"(view: '/error')

//    "/text/$id" {
//      controller: "textCloud"
//      action = [GET:"load", PUT:"upload", POST:"upload"]
//    }
  }
}
