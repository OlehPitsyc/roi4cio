package loginData;

public class UserModel {

	private final String email;
	
	private final String password;

	public UserModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	} 
	
	
}
