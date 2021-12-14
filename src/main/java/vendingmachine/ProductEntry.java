package vendingmachine;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class ProductEntry {
	private static final String PRODUCT_ENTRY_SEPARATOR = ";";
	private static final int INDEX_OF_PRODUCT_PRICE = 1;
	private static final int INDEX_OF_PRODUCT_NUMBER = 2;

	private final int price;
	private int number;

	public ProductEntry(final int price, final int number) {
		this.price = price;
		this.number = number;
	}

	public int getPrice() {
		return this.price;
	}

	public void decrementNumber() {
		number--;
	}

	public boolean isAffordable(final int money) {
		return money >= price;
	}

	public static List<String> getProductEntries() {
		Guide.ITEM_REQUEST.println();
		String productEntriesInString = Console.readLine();
		ProductEntrySyntacticValidator syntacticValidator = new ProductEntrySyntacticValidator();
		ProductEntrySemanticValidator semanticValidator = new ProductEntrySemanticValidator();
		List<String> productEntries = Arrays.asList(productEntriesInString.split(PRODUCT_ENTRY_SEPARATOR));
		if (!syntacticValidator.validate(productEntries)
			|| !semanticValidator.validate((productEntries))) {
			return getProductEntries();
		}
		return productEntries;
	}

	public static ProductEntry createProductEntry(String[] elements) {
		int productPrice = Integer.parseInt(getTrimmedEntryElementByIndex(elements, INDEX_OF_PRODUCT_PRICE));
		int productNumber = Integer.parseInt(elements[INDEX_OF_PRODUCT_NUMBER].trim());
		return new ProductEntry(productPrice, productNumber);
	}

	public static String getTrimmedEntryElementByIndex(String[] elements, int index) {
		return elements[index].trim();
	}

}
