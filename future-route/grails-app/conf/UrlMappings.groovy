class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?(.$format)?" {
            constraints {}
        }

        '/'(controller: 'user')

        '500'(view: '/error')
    }
}
