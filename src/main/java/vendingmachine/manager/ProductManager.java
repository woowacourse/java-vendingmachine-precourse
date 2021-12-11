package vendingmachine.manager;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;

	public ProductManager() {
		this.productList = new ArrayList<>();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public int searchProductPrice(String name) {
		// TODO : 이름으로 상품을 찾고 해당 상품의 가격을 반환한다.
		Product product = searchProduct(name);
		checkProductIsNull(product);
		return product.getPrice();
	}

	public void deductQuantityOfProduct(String name, int reduceValue) {
		// TODO : 이름으로 상품을 찾고 해당 상품의 수량을 차감한다.
		Product product = searchProduct(name);
		checkProductIsNull(product);
		product.reduceQuantity(reduceValue);
	}

	public boolean checkHaveStock(String name) {
		// TODO : 이름으로 상품을 찾고 해당 상품의 재고가 1이상인지 확인한다.
		Product product = searchProduct(name);
		checkProductIsNull(product);
		return product.getPrice() > 0;
	}

	private Product searchProduct(String name) {
		// TODO : 이름으로 상품을 찾고 반환한다.
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}

	private void checkProductIsNull(Product product) {
		if(product == null) {
			throw new IllegalArgumentException();
		}
	}
}
