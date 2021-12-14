package vendingmachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductTable {
	private final Map<String, ProductEntry> products;

	public ProductTable() {
		products = new HashMap<>();
	}

	public void push(final String name, final ProductEntry entry) {
		products.put(name, entry);
	}

	public int getLeftMoney(final String name, final int money) {
		ProductEntry entry = products.get(name);
		int productPrice = entry.getPrice();
		return money - productPrice;
	}

	public void buy(final String name) {
		ProductEntry entry = products.get(name);
		entry.decrementNumber();
	}

	public boolean isAnythingToBuy(final int money) {
		Iterator<ProductEntry> iterator = products.values().iterator();
		while (iterator.hasNext()) {
			ProductEntry entry = iterator.next();
			if (entry.isAffordable(money)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAffordableProduct(final String name, final int money) {
		ProductEntry entry = products.get(name);
		return entry.isAffordable(money);
	}

	public boolean hasProductName(String productName) {
		return products.containsKey(productName);
	}
}
