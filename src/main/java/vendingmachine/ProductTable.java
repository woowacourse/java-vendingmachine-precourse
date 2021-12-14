package vendingmachine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductTable {
	private static final String PRODUCT_ENTRY_ELEMENT_SEPARATOR = ",";
	private static final int INDEX_OF_PRODUCT_NAME = 0;
	private static final int BRACKET_CHAR_LENGTH = 1;

	private final Map<String, ProductEntry> products;

	public ProductTable() {
		products = new HashMap<>();
	}

	public void setProductTable() {
		List<String> productEntries = ProductEntry.getProductEntries();
		productEntries.forEach(entry -> {
			String entryWithoutBlank = entry.trim();
			String[] elements = entryWithoutBlank
				.substring(BRACKET_CHAR_LENGTH, entryWithoutBlank.length() - BRACKET_CHAR_LENGTH)
				.split(PRODUCT_ENTRY_ELEMENT_SEPARATOR);
			push(ProductEntry.getTrimmedEntryElementByIndex(elements, INDEX_OF_PRODUCT_NAME),
				ProductEntry.createProductEntry(elements));
		});
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
