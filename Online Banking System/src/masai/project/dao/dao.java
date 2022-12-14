package masai.project.dao;

import java.util.List;

import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;

public interface dao {

	public String registerCustomer(Customer customer)throws CustomerException;
	
	public Customer loginCustomer(String username, String password)throws CustomerException;
	
	public boolean checkForAccountant();
	
	public void displayHomepageOptionToUser();
	
	public void accountantAddAccountForCustomer();
	
	public void accountantUpdateExistingCustomerAccount();
	
	public void accountantDeleteCustomerAccount();
	
	public void accountantViewCustomerDetais();
	
	public List<Customer> getListOfCustomer();
	
	
}
