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

	public Product checkProductExist(String name) throws IllegalArgumentException{
		Product product = searchProduct(name);
		if(product == null) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_PRODUCT_NOT_EXIST);
		}
		return product;
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

	public int buyProduct(String name, int userBalance) {
		Product product = searchProduct(name);
		if(!product.checkCanBuyWithMoney(userBalance)) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_USER_BALANCE_NOT_ENOUGH);
		}
		product.reduceQuantity(1);
		return product.getPrice();
	}
}
