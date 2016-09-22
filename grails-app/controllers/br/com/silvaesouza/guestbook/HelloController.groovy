package br.com.silvaesouza.guestbook

class HelloController {

    def index() { [userList:User.list(), count: User.count()] }
	
	def hi() {  }
	
}
