package es.basallo

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

// TODO - Adjust roles
@Secured(['ROLE_ADMIN'])
class JsonRestApiController {

  def beforeInterceptor = {
    // TODO - Limit access
    header 'Access-Control-Allow-Origin', '*'
    header 'Access-Control-Allow-Methods', 'GET'
  }

  def index() {
    render Post.list() as JSON
  }
}
