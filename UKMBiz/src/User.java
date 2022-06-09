
public class User {
	
	private String Username;
	private String Password;
	private String PhoneNumber;
	private String Email;
	//private String Address;
	//private Vehicle vehicleInfo;
	
	public User(String username, String password, String phone, String email) {
		Username = username;
		Password = password;
		PhoneNumber = phone;
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	
	}
