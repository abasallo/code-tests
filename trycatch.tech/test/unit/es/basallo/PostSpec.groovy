package es.basallo

import es.basallo.security.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

@TestFor(Post)
@Mock(Post)
@TestMixin(DomainClassUnitTestMixin)
class PostSpec extends Specification {

  def setupSpec() {}

  def cleanupSpec() {}

  def setup() {}

  def 'all fields are mandatory'() {
    expect:
    !new Post().validate()
    !new Post(text: 'text').validate()
    !new Post(user: new User()).validate()
    new Post(text: 'text', user: new User()).validate()
  }

  def 'text cannot be blank'() {
    new Post(text: '', new User())
  }
}




