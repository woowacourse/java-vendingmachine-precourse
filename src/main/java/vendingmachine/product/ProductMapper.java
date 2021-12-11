package vendingmachine.product;

public class ProductMapper {
	private static final String ERROR_INPUT_FORMAT = "상품은 상품명, 가격, 수량을 쉼표로 구분하여 입력해야 합니다.";
	private static final String DELIMITER = ",";
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;
	private static final int STARTING_NUMBER_OF_PRODUCT = 1;
	private static final int ENDING_NUMBER_OF_PRODUCT = 1;
	private static final int NUMBER_OF_INPUT_COLUMN = 3;

	public Product mapFrom(String produceRequest, ProductValidator productValidator) {
		return createProduct(getProductInformation(removeProductsDelimiter(produceRequest)), productValidator);
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

	private Product createProduct(String[] productInformation, ProductValidator productValidator) {
		String name = productInformation[NAME];
		String price = productInformation[PRICE];
		String quantity = productInformation[QUANTITY];
		productValidator.validate(name, price, quantity);
		return new Product(name, Integer.parseInt(price), Integer.parseInt(quantity));
	}
}
