package masai.project.clientSide;

import java.util.Scanner;

import masai.project.dao.dao;
import masai.project.dao.daoImpl;
import masai.project.useCase.AccountantAddNewAccountForCustomer;
import masai.project.useCase.AccountantDeleteCustomerAccount;
import masai.project.useCase.AccountantUpdateExistingCustomerAccount;

public class ClientSide {

	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("Welcome to Online Banking System");
		daoImpl d = new daoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please select your profile by entering the number below-->");
		System.out.println("1. Accountant");
		System.out.println("2. Customer");
		
		int result = sc.nextInt();
		
		if(result==2) {
			
			System.out.println("Enter Customer email: ");
			String email = sc.next();
			
			System.out.println("Enter Customer password: ");
			int pass = sc.nextInt();
			
			d.loginCustomer(email, pass);
			
			while(d.isFlag()) {
				System.out.println("Please select the option you want: ");
				System.out.println();
				System.out.println("1. Transfer money to your account to other.");
				System.out.println("2. View transaction history.");
				System.out.println("3. Exit");
				
				int ch = sc.nextInt();
				
				if(ch==1) {
					System.out.println();
					System.out.println("Enter the account number where you transfer your money:");
					int accountn = sc.nextInt();
					System.out.println("Enter the amount: ");
					int amount = sc.nextInt();
					d.withdrwalAmount(d.getActnum(), amount);
					d.depositAmount(accountn, amount);
					
				}
				else if(ch==2) {
					d.showTransaction(d.getActnum());
				}
				else if(ch==3)
					break;
				else
					System.out.println("Invalid option. Please select Valid Option!");
			}
		}
		else if(result==1) {
			System.out.println("Enter Accountant Email: ");
			String email = sc.next();
			System.out.println("Enter Accountant Password: ");
			int pass = sc.nextInt();
			
		}
	}
}