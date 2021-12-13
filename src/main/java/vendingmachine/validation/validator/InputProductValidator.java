package vendingmachine.validation.validator;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.validation.GlobalValidation;

public class InputProductValidator {

	public static void validateProduct(String[] product, List<Product> products) {
		GlobalValidation.validateProductLengthAndBlank(product);
		GlobalValidation.validateProductPrice(product[1]);
		GlobalValidation.validateProductAmount(product[2]);
		GlobalValidation.validateProductIsDistinct(new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])), products);
	}
}
