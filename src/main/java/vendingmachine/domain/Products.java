package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products {
	private List<Product> products = new ArrayList<>();

	public Products() {}

	public void add(Product product) {
		products.add(product);
	}

	public Money getCheapestPrice() {
		removeSoldOutProduct();
		if (products.isEmpty()) {
			return new Money(0);
		}
		return Collections.min(products).getPrice();
	}

	public void removeSoldOutProduct() {
		for (Product product : products) {
			if (product.soldOut()) {
				products.remove(product);
			}
		}
	}

	public boolean soldOut() {
		for (Product product : products) {
			if (!product.soldOut()) {
				return true;
			}
		}
		return false;
	}

	public boolean isBuy(Money insertMoney) {
		removeSoldOutProduct();
		if (products.isEmpty()) {
			return false;
		}
		if (getCheapestPrice().compareTo(insertMoney) > 0) {
			return false;
		}
		return true;
	}

	public boolean contains(String productName) {
		for (Product product : products) {
			if (product.equals(productName)) {
				return true;
			}
		}
		return false;
	}
}
