package vendingmachine.model.service;

import vendingmachine.model.domain.Product;
import vendingmachine.util.Constant;
import vendingmachine.util.Utils;
import vendingmachine.validator.Validator;

public class ProductService {
	public Product createProduct(String productInformation) throws IllegalArgumentException {
		productInformation = productInformation.replace(Constant.OPEN_SQUARE_BRACKET, "").replace(Constant.CLOSING_SQUARE_BRACKET, "");
		String[] productInfo = productInformation.split(Constant.PRODUCT_DETAIL_SEPARATOR);

		Validator.validateProduct(productInfo);

		String name = productInfo[0];
		int price = Utils.moneyConverter(productInfo[1]);
		int amount = Integer.parseInt(productInfo[2]);

		return new Product(name, price, amount);
	}


}
