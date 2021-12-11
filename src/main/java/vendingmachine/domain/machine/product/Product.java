package vendingmachine.domain.machine.product;

import vendingmachine.domain.user.Balance;
import vendingmachine.exception.MoneyIsNotEnoughMessageException;
import vendingmachine.exception.ProductSoldOutMessageException;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void checkSellable(Balance balance) {
		checkMoneyIsEnough(balance.getMoney());
		checkProductIsSoldOut();
	}

	private void checkMoneyIsEnough(int money) {
		if (this.price > money) {
			throw new MoneyIsNotEnoughMessageException();
		}
	}

	private void checkProductIsSoldOut() {
		if (isSoldOut()) {
			throw new ProductSoldOutMessageException();
		}
	}

	public boolean isSoldOut() {
		return !isNotSoldOut();
	}

	public boolean isNotSoldOut() {
		return (this.quantity > 0);
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

}
