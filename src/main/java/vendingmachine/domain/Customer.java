package vendingmachine.domain;

import vendingmachine.view.OutputView;

public class Customer {
	private int money;

	public Customer(int money) {
		this.money = money;
	}

	public void showChanges() {
		OutputView.printCustomerChanges(money);
	}

	public void purchaseProducts(int productCost) {
		this.money -= productCost;
	}
}
