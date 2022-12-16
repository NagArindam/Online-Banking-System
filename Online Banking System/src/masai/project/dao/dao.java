package masai.project.dao;

import java.sql.SQLException;
import java.util.List;

import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;

public interface dao {

//	public String registerCustomer(Customer customer)throws CustomerException;
//	
//	public Customer loginCustomer(String username, String password)throws CustomerException;
//	
//	public boolean checkForAccountant();
//	
//	public void displayHomepageOptionToUser();
//	
//	public void displayOptionforAccountant();
//	
//	public void accountantAddAccountForCustomer();
//	
//	public void accountantUpdateExistingCustomerAccount();
//	
//	public void accountantDeleteCustomerAccount(String customeremail);
//	
//	public void accountantViewCustomerDetais();
//	
//	public List<Customer> getListOfCustomer() throws SQLException, CustomerException;
//	
//	public int getCustomerid(String customername)throws SQLException, CustomerException;
//
//	public void accountantUpdateExistingCustomerAccount(String customername, String customeraddress);
	
	abstract void registerCustomer(int cusId, String name, String cusEmail, int pass, int bal );
	
	abstract void loginCustomer(String email,int pass);
	
	abstract void withdrwalAmount(int actNo,int money);
	
	abstract void depositAmount(int actNo,int money);
	
	abstract void showTransaction(int actn);
	
}
