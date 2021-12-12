package vendingmachine.domain;

public class Product {
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;
	private static final String PRODUCT_ELEMENT_SPLIT = ",";

	private Name name;
	private Price price;
	private Quantity quantity;

	private Product(Name name, Price price, Quantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String name, String price, String quantity) {
		this(Name.from(name), Price.from(price), Quantity.from(quantity));
	}

	public static Product from(String product) {
		final String[] product_element = product.split(PRODUCT_ELEMENT_SPLIT);
		return new Product(product_element[NAME_INDEX], product_element[PRICE_INDEX], product_element[QUANTITY_INDEX]);
	}
}
