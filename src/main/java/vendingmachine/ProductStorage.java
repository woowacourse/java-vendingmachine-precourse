package vendingmachine;

import java.util.HashMap;

public class ProductStorage {
	private static final String DELIMITER = ",";
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;
	private static final int STARTING_NUMBER_OF_PRODUCT = 1;
	private static final int ENDING_NUMBER_OF_PRODUCT = 1;
	private static final int NUMBER_OF_INPUT_COLUMN = 3;
	private static final String ERROR_INPUT_FORMAT = "상품은 상품명, 가격, 수량을 쉼표로 구분하여 입력해야 합니다.";
	private static final String ERROR_NAME_DUPLICATE = "상품명은 중복될 수 없습니다.";

	HashMap<String, Product> storage;

	public HashMap<String, Product> createProducts(String request) {
		storage = new HashMap<>();
		for (String each : request.split(";")) {
			addProduct(getProductInformation(removeProductsDelimiter(each)));
		}
		return storage;
	}

	private String removeProductsDelimiter(String produceRequest) {
		return produceRequest.substring(STARTING_NUMBER_OF_PRODUCT, produceRequest.length() - ENDING_NUMBER_OF_PRODUCT);
	}

	private String[] getProductInformation(String produceRequest) {
		String[] productInformation = produceRequest.split(DELIMITER);
		validateInputFormat(productInformation);
		return productInformation;
	}

	private void validateInputFormat(String[] productInformationArray) {
		if (productInformationArray.length != NUMBER_OF_INPUT_COLUMN) {
			throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
		}
	}

	private String validateName(String name) {
		validateDuplicateName(name);
		return name;
	}

	private void validateDuplicateName(String name) {
		if (storage.containsKey(name)) {
			throw new IllegalArgumentException(ERROR_NAME_DUPLICATE);
		}
	}

	private void addProduct(String[] productInformation) {
		String name = validateName(productInformation[NAME]);
		String price = productInformation[PRICE];
		String quantity = productInformation[QUANTITY];
		storage.put(name, new Product(price, quantity));
	}

}
