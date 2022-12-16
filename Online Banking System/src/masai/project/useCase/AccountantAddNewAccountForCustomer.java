package masai.project.useCase;

import masai.project.dao.dao;
import masai.project.dao.daoImpl;

public class AccountantAddNewAccountForCustomer {

	public AccountantAddNewAccountForCustomer() {
		dao d = new daoImpl();
		d.accountantAddAccountForCustomer();
	}
}
