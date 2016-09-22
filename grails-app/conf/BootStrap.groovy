import br.com.silvaesouza.guestbook.Commentary;
import br.com.silvaesouza.guestbook.Feedback;
import br.com.silvaesouza.guestbook.User;

class BootStrap {

    def init = { servletContext ->
		User user = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.com')
		User otherUser = new User(name:'jim', email:'jim@muster.com', webpage:'http://www.vogella.com')
		User silvaesouza = new User(name:'Adriano', email:'silvaesouza@gmail.com', login:'silvaesouza')
		if (!user.save()){
			log.error "Could not save user!!"
			log.error "${user.errors}"
		}
		if (!otherUser.save()){
			log.error "Could not save otherUser!!"
		}
		if (!silvaesouza.save()){
			log.error "Could not save silvaesouza!!"
		}

		Feedback feedback = new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user)
		feedback.save()

		Commentary comment = new Commentary(commentary:'Hello, my name is Jim', user:otherUser)
		comment.feedback = feedback
		comment.save(); 
	}

	def destroy = {
	}
}
