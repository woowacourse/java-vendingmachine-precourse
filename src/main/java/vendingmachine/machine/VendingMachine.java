package vendingmachine.machine;

import java.util.HashMap;

import vendingmachine.money.Changes;
import vendingmachine.money.Coin;
import vendingmachine.money.Money;
import vendingmachine.money.Payments;
import vendingmachine.product.ProductStorage;

public class VendingMachine {
	private Changes changes;
	private ProductStorage productStorage;
	private Payments payments;

	public VendingMachine(Changes changes, ProductStorage productStorage) {
		this.changes = changes;
		this.productStorage = productStorage;
		this.payments = new Payments();
	}

	public void insertMoney(String money) {
		payments.insert(money);
	}

	public boolean isUsable() {
		return productStorage.isSellable(payments.getRemainMoney());
	}

	public Money calculateRemainMoney() {
		return payments.getRemainMoney();
	}

	public void trade(String product) {
		payments.payProductValue(productStorage.sellProduct(product));
	}

	public HashMap<Coin, Integer> returnChange() {
		return changes.calculateChange(payments.getRemainMoney());
	}
}
