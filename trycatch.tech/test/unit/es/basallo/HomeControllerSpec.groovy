package es.basallo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(HomeController)
class HomeControllerSpec extends Specification {

  def 'index shows default view'() {

    when:
    controller.index()

    then:
    response.redirectedUrl == null
  }
}
