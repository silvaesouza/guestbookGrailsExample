package br.com.silvaesouza.guestbook

class User {

	Integer id
    String name
	String email
	//String webpage
	String login
	String password
	Boolean enabled
	
	static mapping = {
		table 'nbs_user'
		id column: 'USER_ID', generator:'native', params:[sequence:'nbs_user_s']
		name column: 'USER_NAME'
		email column: 'USER_EMAIL'
		login column: 'USER_LOGIN'
		password column: 'USER_PASSWORD'
		enabled column: 'ENABLED_FLAG'
		//enabled type: 'true_false' -- 'T' or 'F'
		//enabled type: 'yes_no' -- 'Y' or 'N'
		enabled type: 'org.hibernate.type.NumericBooleanType' // -- 1 or 0
	}

	static constraints = {
		id (nullable:true)
		name (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z1-9_]+") 
		email (email:true)
		//webpage (nullable:true, url:true)
		login(nullable:true)
		password(nullable:true)
		enabled(nullable:true)
	}

	String toString(){
		return name; 
	}
	
}
