package application;

import java.sql.ResultSet;

public class NewUser extends User {
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}
	
	public NewUser(String userid, String password, String firstName, String lastName, String email){
		super(userid.trim());
		this.password = password.trim();
		this.firstName = firstName.trim();
		this.lastName = lastName.trim();
		this.email = email.trim();
	}
	
	public boolean createUser(){
		if(userExists()){
			System.out.println("User already Exists");
			return false;
		}else{
			String insertUser = String.format("INSERT INTO users VALUES('%s','%s','%s','%s','%s')", getUserid(), getPassword(), getFirstName(), getLastName(), getEmail());
			if(db.changeQuery(insertUser)){
				System.out.println("User created: \nName: " + getFirstName() + " " + getLastName() + "\nUser ID: " + getUserid());
				return true;
			}else{
				System.out.println("User wasn't inserted in the database!");
				return false;
			}
			
		}
	}
	
	
	
}
