package vendingmachine.manager;

import java.util.List;

import vendingmachine.constants.ErrorConstants;
import vendingmachine.domain.Product;

public class ProductManager {
	private final List<Product> productList;
	private final int lowPrice;

	public ProductManager(List<Product> products) {
		this.productList = products;
		this.lowPrice = checkLowPrice(products);
	}

	private int checkLowPrice(List<Product> productList) {
		return productList.stream()
			.mapToInt(Product::getPrice)
			.min()
			.orElseThrow(IllegalArgumentException::new);
	}

	public Product searchProduct(String name) {
		Product product = findProductByName(name);
		if(product == null) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_NOT_EXIST);
		}
		return product;
	}

	private Product findProductByName(String name) {
		return productList.stream()
			.filter(product -> name.equals(product.getName()))
			.findAny()
			.orElse(null);
	}

	public boolean checkCanBuyProduct(int userBalance) {
		return checkUserCanBuyProduct(userBalance) && checkAllProductNotOutOfStock();
	}

	private boolean checkUserCanBuyProduct(int userBalance) {
		return userBalance >= this.lowPrice;
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
