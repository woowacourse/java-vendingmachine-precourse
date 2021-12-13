package vendingmachine.domain;

import vendingmachine.utils.ErrorMessage;

public class Customer {
	private int money;

	public Customer(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void purchaseProduct(int productCost) {
		if (productCost > money) {
			throw new IllegalArgumentException(ErrorMessage.CAN_NOT_BUY_PRODUCT_MESSAGE);
		}
		this.money -= productCost;
	}

	public boolean hasMoney() {
		return money > 0;
	}

}
