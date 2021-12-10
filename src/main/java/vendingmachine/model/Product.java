package vendingmachine.model;

import vendingmachine.util.NameException;
import vendingmachine.util.NumberException;
import vendingmachine.util.ProductException;

public class Product {
	public String name;
	public int price;
	public int quantity;

	public Product(String productStr) {
		String[] productInfo = productStr.split(",", -1);

		ProductException.checkProductInfoSize(productInfo);

		name = NameException.checkNameException(productInfo[0]);
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

		if (price >= insertedMoney) {
			return price;
		}

		return 0;
	}

}
