package masai.project.Bean;

public class Customer {

	private int actNo;
	private String name;
	private String email;
	private String pass;
	private String balance;
	
	public int getActNo() {
		return actNo;
	}

	public void setActNo(int actNo) {
		this.actNo = actNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [actNo=" + actNo + ", name=" + name + ", email=" + email + ", pass=" + pass + ", balance="
				+ balance + "]";
	}

	public Customer(int actNo, String name, String email, String pass, String balance) {
		super();
		this.actNo = actNo;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.balance = balance;
	}
	
	
	
	
	
	
}
