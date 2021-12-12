package vendingmachine.manager;

import java.util.List;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;

	public ProductManager(List<Product> products) {
		this.productList = products;
	}

	public void checkProductExist(String name) throws IllegalArgumentException{
		Product product = searchProduct(name);
		if(product == null) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_NOT_EXIST);
		}
	}

	public Product searchProduct(String name) {
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}

	public boolean checkCanBuyProduct(int userBalance) {
		return checkUserCanBuyProduct(userBalance) && checkAllProductNotOutOfStock();
	}

	private boolean checkUserCanBuyProduct(int userBalance) {
		for(Product product : productList) {
			if(product.checkCanBuyWithMoney(userBalance)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkAllProductNotOutOfStock() {
		for(Product product : productList) {
			if(product.checkHaveStock()) {
				return true;
			}
		}
		return false;
	}
}
