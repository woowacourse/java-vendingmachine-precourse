package vendingmachine;

import vendingmachine.user.Administrator;
import vendingmachine.user.Customer;

public class VendingMachine {

	private final Administrator administrator;
	private final Customer customer;

	public VendingMachine(Administrator administrator, Customer customer) {
		this.administrator = administrator;
		this.customer = customer;
	}

	public void start() {
		administrator.initialize();
		customer.purchase();
	}
}
