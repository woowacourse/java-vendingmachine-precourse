package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class ProductTable {
	private final Map<String, ProductEntry> products;

	public ProductTable() {
		products = new HashMap<>();
	}

	public void push(String name, ProductEntry entry) {
		products.put(name, entry);
	}

	public void buy(String name) {
		ProductEntry entry = products.get(name);
		entry.decrementNumber();
	}
}
