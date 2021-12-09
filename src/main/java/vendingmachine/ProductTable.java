package vendingmachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductTable {
	private final Map<String, ProductEntry> products;

	public ProductTable() {
		products = new HashMap<>();
	}

	public void push(String name, ProductEntry entry) {
		products.put(name, entry);
	}

	public int buy(String name, int money) {
		ProductEntry entry = products.get(name);
		int productPrice = entry.getPrice();
		if (productPrice > money) {
			return money;
		}

		entry.decrementNumber();
		return money - productPrice;
	}

	public boolean isAnythingToBuy(int money) {
		Iterator<ProductEntry> iterator = products.values().iterator();

		while (iterator.hasNext()) {
			ProductEntry entry = iterator.next();
			if (entry.isAffordable(money)) {
				return true;
			}
		}

		return false;
	}
}
