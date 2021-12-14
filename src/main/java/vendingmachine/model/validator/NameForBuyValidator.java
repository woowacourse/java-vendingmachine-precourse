package vendingmachine.model.validator;

import vendingmachine.model.Product;
import vendingmachine.model.service.CustomerService;
import vendingmachine.model.service.ProductService;

public class NameForBuyValidator {

	public static final String IS_MATCH_TO_PRODUCT_ERROR_MESSAGE = "[ERROR] 일치하는 상품이 없습니다.";
	public static final String IS_STOCK_EMPTY_ERROR_MESSAGE = "[ERROR] 남은 재고가 없는 상품입니다.";
	public static final int EMPTY_STOCK_COUNT = 0;

	ProductService productService = new ProductService();

	public boolean validate(String name) {
		try {
			if (name.equals(CustomerService.CHANGE_REQUIRE_WORD_FROM_CUSTOMER)) {
				return false;
			}
			isMatchToProduct(name);
			isStockAvailable(name);
			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	private void isMatchToProduct(String name) throws IllegalArgumentException {
		Product product = productService.getByName(name);

		if (ProductService.FAIL_TO_FIND_MESSAGE_THROUGH_PRODUCT_NAME.equals(product.getName())) {
			System.out.println(IS_MATCH_TO_PRODUCT_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isStockAvailable(String name) throws IllegalArgumentException {
		int stock = productService.getByName(name).getStock();

		if (stock == EMPTY_STOCK_COUNT) {
			System.out.println(IS_STOCK_EMPTY_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}
}
