package vendingmachine.manager;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;

	public ProductManager() {
		this.productList = new ArrayList<>();
	}

	public void addAllProduct(List<Product> products) {
		productList.addAll(products);
	}

	public void checkProductExist(String name) throws IllegalArgumentException{
		Product product = searchProduct(name);
		if(product == null) {
			throw new IllegalArgumentException();
		}
	}

	public boolean checkCanBuyProduct(String name, int userBalance) {
		Product product = searchProduct(name);
		if(product.compareToPrice(userBalance) && product.checkHaveStock()) {
			return true;
		}
		return false;
	}

	public void deductQuantityOfProduct(String name, int reduceValue) {
		Product product = searchProduct(name);
		product.reduceQuantity(reduceValue);
	}

	public Product searchProduct(String name) {
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}

}
