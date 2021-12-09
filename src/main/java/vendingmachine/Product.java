package vendingmachine;

public class Product {
	private static final String DELIMITER = ",";
	private static final int STARTING_NUMBER_OF_PRODUCT = 1;
	private static final int ENDING_NUMBER_OF_PRODUCT = 1;
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int QUANTITY_INDEX = 2;

	private String name;
	private int price;
	private int quantity;

	public Product(String produceRequest) {
		produceRequest = removeProductDelimiter(produceRequest);
		String[] productInformationArray = produceRequest.split(DELIMITER);
		name = productInformationArray[NAME_INDEX];
		price = Integer.parseInt(productInformationArray[PRICE_INDEX]);
		quantity = Integer.parseInt(productInformationArray[QUANTITY_INDEX]);
	}

	private String removeProductDelimiter(String produceRequest) {
		return produceRequest.substring(STARTING_NUMBER_OF_PRODUCT, produceRequest.length() - ENDING_NUMBER_OF_PRODUCT);
	}
}
