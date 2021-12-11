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
		return -1;
	}

	public void deductQuantityOfProduct(String name) {
		// TODO : 이름으로 상품을 찾고 해당 상품의 수량을 1 차감한다.
	}

	public boolean checkHaveStock(String name) {
		// TODO : 이름으로 상품을 찾고 해당 상품의 재고가 1이상인지 확인한다.
		return false;
	}

	private Product searchProduct(String name) {
		// TODO : 이름으로 상품을 찾고 반환한다.
		return null;
	}
}
