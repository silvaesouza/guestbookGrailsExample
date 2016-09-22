package br.com.silvaesouza.guestbook

class Commentary {
	
    String commentary
	Date dateCreated // Predefined names by Grails will be filled automatically
	Date lastUpdated // Predefined names by Grails will be filled automatically

	User user;
	// delete a comments for a feedback if the feedback item is deleted
	static belongsTo=[feedback:Feedback]

	static constraints = {
		commentary (blank:false, nullable: false, size:5..500)
		user (nullable: true) // Comments are allowed without a user
	}

	String toString(){
	if (commentary?.size()>20){
		return commentary.substring(0,19);
	} else 
		return commentary; 
	}
	
}
