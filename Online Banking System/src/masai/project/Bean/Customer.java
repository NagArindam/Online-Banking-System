package masai.project.Bean;

public class Customer {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + "]";
	}

	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
