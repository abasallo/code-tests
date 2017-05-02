package es.basallo

import grails.plugin.springsecurity.annotation.Secured

// TODO - Adjust roles
@Secured(['ROLE_ADMIN'])
class HomeController {
  def index() {}
}
