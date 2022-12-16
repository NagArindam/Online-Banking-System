package masai.project.useCase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;
import masai.project.dao.dao;
import masai.project.dao.daoImpl;

public class AccountantDeleteCustomer {

//	public AccountantDeleteCustomer() throws SQLException, CustomerException {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		dao d = new daoImpl();
//		
//		List<Customer> listofcustomers = d.getListOfCustomer();
//		
//		System.out.println("List of Customers Details: ");
//		
//		listofcustomers.forEach(c -> System.out.println(c.getCustomerid()));
//		
//		System.out.println("Enter customerid to delete:");
//		
//		int customerid = sc.nextInt();
//		d.accountantAddAccountForCustomer();
//	}
	public static void main(String[] args) throws SQLException, CustomerException {
		Scanner sc = new Scanner(System.in);
		
		dao d = new daoImpl();
		
		List<Customer> listofcustomers = d.getListOfCustomer();
		
		System.out.println("List of Customers Details: ");
		
		listofcustomers.forEach(c -> System.out.println(c.getCustomername()));
		
		System.out.println("Enter customer name to delete:");
		
		String customername = sc.next();
		d.accountantDeleteCustomerAccount(customername);
	}
}
