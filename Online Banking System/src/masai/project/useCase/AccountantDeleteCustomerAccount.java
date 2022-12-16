package masai.project.useCase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;
import masai.project.dao.dao;
import masai.project.dao.daoImpl;

public class AccountantDeleteCustomerAccount {

	public AccountantDeleteCustomerAccount() throws SQLException, CustomerException {
		
		Scanner sc = new Scanner(System.in);
		dao d = new daoImpl();
		List<Customer> listOfCustomer = d.getListOfCustomer();
		
		System.out.println("List of Customers==>");
		listOfCustomer.forEach(c -> System.out.println(c.getCustomername()));
		
		System.out.println("Enter Customer name to delete: ");
		String customername = sc.next();
		d.accountantDeleteCustomerAccount(customername);
	}
}
