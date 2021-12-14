package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.List;

import vendingmachine.service.ProductService;

public class Product {
	private String name;
	private int price;
	private int count;

	private Product(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product makeProduct(String inputLine) {
		List<String> strings = ProductService.splitProductElements(inputLine);
		return new Product(strings.get(PRODUCT_NAME_INDEX),
			Integer.parseInt(strings.get(PRODUCT_PRICE_INDEX)),
			Integer.parseInt(strings.get(PRODUCT_COUNT_INDEX)));
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public boolean hasMoreThanOneCount() {
		return this.count > PRODUCT_COUNT_ZERO;
	}

	public boolean isCheaperOrSameThan(long money) {
		return money >= price;
	}

	public int getPrice() {
		return price;
	}

	public boolean soldOut() {
		return count == PRODUCT_COUNT_ZERO;
	}

	public void consume() {
		count -= COIN_CONSUME_AMOUNT;
	}
}

