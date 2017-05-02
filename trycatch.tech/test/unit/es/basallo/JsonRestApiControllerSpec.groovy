package es.basallo

import es.basallo.security.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(JsonRestApiController)
@Mock([Post, User])
class JsonRestApiControllerSpec extends Specification {

  def 'returns all Posts'() {

    given:
    def user = new User(username: 'user', password: 'user', name: 'User',
      accountExpired: false, accountLocked: false, passwordExpired: false).save()
    def post = new Post(user: user, text: "text").save()

    when:
    controller.index()

    then:
    response.text == '[{"class":"es.basallo.Post","id":1,"text":"text","user":{"class":"es.basallo.security.User","id":1}}]'
  }
}
