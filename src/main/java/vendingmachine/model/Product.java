package vendingmachine.model;

import vendingmachine.constants.Rule;
import vendingmachine.util.NumberException;
import vendingmachine.util.ProductException;
import vendingmachine.util.StringException;

public class Product {
	public String name;
	public int price;
	public int quantity;

	public Product(String productStr) {
		String[] productInfo = productStr.split(Rule.STANDARD_FOR_DIVIDE_PRODUCT_INFO, -1);

		ProductException.checkProductInfoSize(productInfo);

		name = StringException.checkStringException(productInfo[0]);
		price = NumberException.checkPriceException(productInfo[1]);
		quantity = NumberException.checkQuantityException(productInfo[2]);
	}

	public String getName() {
		return name;
	}

	public boolean findQuantity() {
		return quantity > 0;
	}

	public int comparePrice(int insertedMoney) {

		if (price <= insertedMoney) {
			return price;
		}

		return 0;
	}

	public boolean canBuyThisProduct(int remainMoney) {

		if (price <= remainMoney && quantity > 0) {
			return true;
		}

		return false;
	}

}
