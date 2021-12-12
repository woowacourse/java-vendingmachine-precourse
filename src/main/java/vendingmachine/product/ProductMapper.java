package vendingmachine.product;

public class ProductMapper {
	private static final String INFORMATION_DELIMITER = ",";
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;
	private static final int WITHOUT_LEFT_PACKAGE_DELIMITER = 1;
	private static final int WITHOUT_RIGHT_PACKAGE_DELIMITER = 1;

	public Product mapFrom(String produceRequest, ProductValidator productValidator) {
		String removedPackageDelimiter = removePackageDelimiter(produceRequest);
		String[] produceRequestArray = getProductInformation(removedPackageDelimiter);
		return createProduct(produceRequestArray, productValidator);
	}

	private String removePackageDelimiter(String produceRequest) {
		return produceRequest.substring(WITHOUT_LEFT_PACKAGE_DELIMITER,
			produceRequest.length() - WITHOUT_RIGHT_PACKAGE_DELIMITER);
	}

	private String[] getProductInformation(String produceRequest) {
		String[] productInformation = produceRequest.split(INFORMATION_DELIMITER);
		return productInformation;
	}

	private Product createProduct(String[] productInformation, ProductValidator productValidator) {
		String name = productInformation[NAME];
		String price = productInformation[PRICE];
		String quantity = productInformation[QUANTITY];
		productValidator.validate(name, price, quantity);
		return new Product(name, Integer.parseInt(price), Integer.parseInt(quantity));
	}
}
