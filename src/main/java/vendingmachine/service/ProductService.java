package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import vendingmachine.repository.ProductRepository;
import vendingmachine.util.Constants;
import vendingmachine.util.ExceptionHandler;
import vendingmachine.validator.InputValidator;

public class ProductService {
	private static final ProductRepository productRepository = new ProductRepository();

	public void deleteProducts() {
		productRepository.deleteAll();
	}

	public boolean validateProduct(String products) {
		List<String> productArray = Arrays.asList(products.split(Constants.PRODUCT_SEPARATOR));
		boolean isValid = InputValidator.isNotEmpty(productArray)
			&& productArray.stream()
			.allMatch(product -> InputValidator.isNotEmpty(product)
				&& InputValidator.isWrappedWithSquareBrackets(product)
				&& validateProductInfo(product));
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_PRODUCT);
		return isValid;
	}

	private boolean validateProductInfo(String productInfo) {
		productInfo = productInfo.substring(1, productInfo.length() - 1);
		List<String> productInfos = Arrays.asList(productInfo.split(Constants.PRODUCT_INFO_SEPARATOR));
		boolean isValid = InputValidator.isNotEmpty(productInfos)
			&& productInfos.size() == Constants.PRODUCT_INFOS_SIZE
			&& productInfos.stream().allMatch(InputValidator::isNotEmpty)
			&& validateProductPrice(productInfos.get(1))
			&& validateProductCount(productInfos.get(2));

		if (isValid) {
			addProduct(productInfos);
		}
		return isValid;
	}

	private boolean validateProductPrice(String price) {
		return InputValidator.isDigit(price)
			&& InputValidator.isGreaterThan(Constants.PRODUCT_PRICE_MIN_VALUE, price)
			&& InputValidator.isDivided(Constants.PRODUCT_PRICE_DENOMINATOR, price);
	}

	private boolean validateProductCount(String count) {
		return InputValidator.isDigit(count)
			&& InputValidator.isGreaterThan(Constants.PRODUCT_COUNT_MIN_VALUE, count);
	}

	private void addProduct(List<String> productInfos) {
		productRepository.add(productInfos);
	}
}
