package masai.project.useCase;

import java.util.Scanner;

import masai.project.dao.dao;
import masai.project.dao.daoImpl;

public class AccountantUpdateExistingCustomerAccount {

	public AccountantUpdateExistingCustomerAccount() {
		Scanner sc = new Scanner(System.in);
		dao d = new daoImpl();
		System.out.println("Enter Customer name: ");
		String customername = sc.next();
		System.out.println("Enter Customer Address to update: ");
		String customeraddress = sc.next();
		d.accountantUpdateExistingCustomerAccount(customername, customeraddress);
	}
}
