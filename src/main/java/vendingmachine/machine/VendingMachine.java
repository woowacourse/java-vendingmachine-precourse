package vendingmachine.machine;

import java.util.HashMap;

import vendingmachine.changes.Changes;
import vendingmachine.money.Coin;
import vendingmachine.money.Money;
import vendingmachine.product.Product;
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

	public Product findProductByName(String product) {
		return productStorage.findProductByName(product);
	}

	public HashMap<Coin, Integer> returnChange(Money money) {
		return changes.calculateChange(money);
	}
}

