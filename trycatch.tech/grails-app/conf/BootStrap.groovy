import es.basallo.Post
import es.basallo.security.User
import es.basallo.security.Role
import es.basallo.security.UserRole
import grails.converters.JSON

// TODO - Refactor to minimize saves
class BootStrap {

  def init = { servletContext ->

    JSON.registerObjectMarshaller(Post) {
      [text: it.text, user: it.user]
    }

    JSON.registerObjectMarshaller(User) {
      [name: it.name]
    }

    def admin = new User(username: 'admin', password: 'admin', name: 'Administrator',
      accountExpired: false, accountLocked: false, passwordExpired: false).save()
    def user = new User(username: 'user', password: 'user', name: 'Regular User',
      accountExpired: false, accountLocked: false, passwordExpired: false).save()
    def guest = new User(username: 'guest', password: 'guest', name: 'Guest User',
      accountExpired: false, accountLocked: false, passwordExpired: false).save()

    def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
    def roleUser = new Role(authority: 'ROLE_USER').save()
    def roleGuest = new Role(authority: 'ROLE_GUEST').save()

    new UserRole(user: admin, role: roleAdmin).save()
    new UserRole(user: user, role: roleUser).save()
    new UserRole(user: guest, role: roleGuest).save()

    def adminPost1 = new Post(user: admin, text: "First admin's post text")
    def adminPost2 = new Post(user: admin, text: "Second admin's post text")
    def userPost1 = new Post(user: user, text: "First user's post text")
    def userPost2 = new Post(user: user, text: "Second user's post text")
    def guestPost1 = new Post(user: guest, text: "First guest's post text")
    def guestPost2 = new Post(user: guest, text: "Second guest's post text")

    admin.posts = [adminPost1, adminPost2]
    user.posts = [userPost1, userPost2]
    guest.posts = [guestPost1, guestPost2]

    admin.save()
    user.save()
    guest.save()

    admin.posts*.save()
    user.posts*.save()
    guest.posts*.save()
  }

  def destroy = {}
}
