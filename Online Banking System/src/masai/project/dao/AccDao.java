package masai.project.dao;

import javax.security.auth.login.AccountException;

import masai.project.Bean.Accountant;
import masai.project.Bean.Customer;
import masai.project.Exception.AccountantException;
import masai.project.Exception.CustomerException;

public interface AccDao {

	public Accountant LoginAccountant(String username, String password)throws AccountantException;
	
	public int addNewCustomer(String cname,String cmail, String cpass, String cmob, String cadd) throws CustomerException;
	
	public String addAccountCustomer(int cbal,int cid) throws AccountException;
	
	public String updateExistingCustomer(int cACno,String cadd) throws CustomerException;

	public  Customer viewCustomerDetails(String cACno) throws CustomerException;
	
	public int getCustomer(String cmail,String cmob) throws CustomerException;
	
	public Customer viewAllCustomer() throws CustomerException;
	
	public String deleteAccount(int cACno) throws CustomerException;
	
}
