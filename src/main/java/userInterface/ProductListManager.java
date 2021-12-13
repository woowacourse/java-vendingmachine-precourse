package userInterface;

import vendingmachine.Products;

public class ProductListManager {
	private Products productList;

	public Products getList() {
		return productList;
	}

	public ProductListManager() {
		initProductList();

	}

	// 입력 자체로 에러를 판단할 수 없어 InputManager() 클래스를 사용하지 않는다.
	private void initProductList() {
		boolean passed = false;
		while (!passed) {
			try {
				passed = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
