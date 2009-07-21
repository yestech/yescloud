class UrlMappings {
  static mappings = {
//    "/$controller/$action?/$id?" {
//      constraints {
//        // apply constraints here
//      }
//    }
    "/text"(controller: "textCloud") {
      action = [PUT:"upload", POST:"upload"]
    }
    
    "/text/$key/$tag"(controller: "textCloud") {
      action = [GET: "loadTag"]
    }

    "/text/$key"(controller: "textCloud") {
      action = [GET: "loadCloud"]
    }

    "/"(view: "/index")
    "500"(view: '/error')

//    "/text/$id" {
//      controller: "textCloud"
//      action = [GET:"load", PUT:"upload", POST:"upload"]
//    }
  }
}
