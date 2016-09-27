package br.com.silvaesouza.guestbook.service

import br.com.silvaesouza.guestbook.User;
import grails.transaction.Transactional

//@Transactional
class UserService {

	def getEmail(String username) {
		//def listOfAllUser = User.executeQuery("from User")
		//def criteria = User.createCriteria()
		//def result = User.list()
		
		/*def result = User.executeQuery(
			"from User where login = :login ",
			[login:username])*/
		
		//println(result)
		
		//return result
		//def list = User.executeQuery("from User where login = 'silvaesouza'")
	}
	
}
