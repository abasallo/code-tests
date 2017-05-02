package es.basallo

import es.basallo.security.User
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Post {

    String text

    static belongsTo = [user: User]

    static constraints = {
      text blank: false
    }
}
