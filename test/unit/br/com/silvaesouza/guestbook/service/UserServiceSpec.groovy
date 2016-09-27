package br.com.silvaesouza.guestbook.service

import br.com.silvaesouza.guestbook.User;
import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock(User)
class UserServiceSpec extends Specification {
	
	User user
	
    def setup() {
    }

    def cleanup() {
    }

	void "test the getEmail"() {
		when: "service is called"
          //"service" represents the grails service you are testing for
          user = service.getEmail('silvaesouza')
		
		then: "Expect something to happen"
			user?.email == 'silvaesouza@gmail.com'
	}
}
