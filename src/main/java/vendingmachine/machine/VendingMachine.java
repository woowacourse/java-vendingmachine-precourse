package vendingmachine.machine;

import java.util.HashMap;

import vendingmachine.money.Changes;
import vendingmachine.money.Coin;
import vendingmachine.money.Money;
import vendingmachine.product.ProductStorage;

public class VendingMachine {
	private Changes changes;
	private ProductStorage productStorage;

	public VendingMachine(Changes changes, ProductStorage productStorage) {
		this.changes = changes;
		this.productStorage = productStorage;
	}

	public boolean isUsable(Money money) {
		return productStorage.isSellable(money);
	}

	public Integer trade(String product) {
		return productStorage.sellProduct(product);
	}

	public HashMap<Coin, Integer> returnChange(Money money) {
		return changes.calculateChange(money);
	}
}

