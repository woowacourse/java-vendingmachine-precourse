package vendingmachine.service;

import java.util.ArrayList;

import vendingmachine.constants.ProductConstant;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;

public class ProductService {

	ProductValidator productValidator = new ProductValidator();

	public Products generate() {
		while (true) {
			try {
				return new Products(replaceString(InputView.getProduct()));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public ArrayList<Product> replaceString(String input) {
		ArrayList<Product> products = new ArrayList<>();

		for (String product : splitInput(input)) {
			String[] item = product.split(ProductConstant.COMMA);
			productValidator.isValid(item);
			products.add(new Product(item[ProductConstant.NAME_INDEX],
				Integer.parseInt(item[ProductConstant.PRICE_INDEX]),
				Integer.parseInt(item[ProductConstant.STOCK_INDEX])));
		}
		return products;
	}

	public String[] splitInput(String input) {
		String[] outputs = input.replaceAll(ProductConstant.LEFT_SQUARE_BRACKET, ProductConstant.BLANK)
			.replaceAll(ProductConstant.RIGHT_SQUARE_BRACKET, ProductConstant.BLANK)
			.split(ProductConstant.SEMI_COLON);
		productValidator.isValidInput(outputs);
		return outputs;
	}
}
