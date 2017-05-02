class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {}
        }

        "/"(controller: "account")
        "500"(view:'/error')
	}
}
