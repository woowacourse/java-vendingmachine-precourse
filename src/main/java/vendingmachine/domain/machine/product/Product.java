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

	public void sell(Balance balance) {
		checkSellable(balance.getMoney());
		decreaseQuantity();
		balance.withdraw(this.price);
	}

	public void checkSellable(int money) {
		checkMoneyIsEnough(money);
		checkProductIsSoldOut();
	}

	private void checkMoneyIsEnough(int money) {
		if (isNotEnoughMoney(money)) {
			throw new MoneyIsNotEnoughMessageException();
		}
	}

	public boolean isNotEnoughMoney(int money) {
		return (this.price > money);
	}

	private void checkProductIsSoldOut() {
		if (isSoldOut()) {
			throw new ProductSoldOutMessageException();
		}
	}

	public boolean isSoldOut() {
		return (this.quantity == 0);
	}

	public boolean isNotSoldOut() {
		return !isSoldOut();
	}

	private void decreaseQuantity() {
		this.quantity--;
	}

	public String getName() {
		return this.name;
	}

}
