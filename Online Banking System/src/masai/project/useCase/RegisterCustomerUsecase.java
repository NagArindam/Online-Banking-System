package masai.project.useCase;

import java.util.Scanner;

import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;
import masai.project.dao.dao;
import masai.project.dao.daoImpl;

public class RegisterCustomerUsecase {

	public RegisterCustomerUsecase() {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer Id: ");
		int customerid = sc.nextInt();
		
		System.out.println("Enter Customer Name: ");
		String customername = sc.next();
		
		System.out.println("Enter Customer Address: ");
		String customeraddress = sc.next();
		
		System.out.println("Enter Customer Email: ");
		String customeremail = sc.next();
		
		System.out.println("Enter Customer Password: ");
		String customerpassword = sc.next();
		
		Customer customer = new Customer(customerid, customername, customeraddress, customeremail, customerpassword);
		customer.setCustomerid(customerid);
		customer.setCustomername(customername);
		customer.setCustomeraddress(customeraddress);
		customer.setCustomeremail(customeremail);
		customer.setCustomerpassword(customerpassword);
		
		dao d = new daoImpl();
		
		try {
		String result = d.registerCustomer(customer);
		
		System.out.println(result);
		
		}catch(CustomerException e ) {
			System.out.println(e.getMessage());
		}
	}

}
