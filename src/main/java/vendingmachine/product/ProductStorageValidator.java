package vendingmachine.product;

public class ProductStorageValidator {
	private static final String ERROR_WRONG_INPUT_FORMAT = "상품에 대한 입력은 '[' 로 시작하여 ']' 로 끝나야 합니다.";
	private static final String ERROR_INPUT_FORMAT = "상품은 상품명, 가격, 수량을 쉼표로 구분하여 입력해야 합니다.";
	private static final String INFORMATION_DELIMITER = ",";
	private static final String MULTIPLE_DELIMITER = ";";
	private static final char LEFT_PACKAGE_DELIMITER = '[';
	private static final char RIGHT_PACKAGE_DELIMITER = ']';
	private static final int START_INDEX = 0;
	private static final int TO_END_INDEX = 1;
	private static final int WITHOUT_LEFT_PACKAGE_DELIMITER = 1;
	private static final int WITHOUT_RIGHT_PACKAGE_DELIMITER = 1;
	private static final int NUMBER_OF_INPUT_COLUMN = 3;

	public void validate(String inputProducts) {
		validateInputFormat(inputProducts);
		for (String each : inputProducts.split(MULTIPLE_DELIMITER)) {
			validateInputFormat(each);
			validateProductInformationFormat(each);
		}
	}

	private void validateInputFormat(String inputProducts) {
		try {
			validatePackageDelimiter(inputProducts);
		} catch (Exception exception) {
			throw new IllegalArgumentException(ERROR_WRONG_INPUT_FORMAT);
		}
	}

	private void validatePackageDelimiter(String inputProducts) {
		if (inputProducts.charAt(START_INDEX) != LEFT_PACKAGE_DELIMITER) {
			throw new IllegalArgumentException();
		}
		if (inputProducts.charAt(inputProducts.length() - TO_END_INDEX) != RIGHT_PACKAGE_DELIMITER) {
			throw new IllegalArgumentException();
		}
	}

	private void validateProductInformationFormat(String inputProducts) {
		String removedPackageDelimiter = inputProducts.substring(WITHOUT_LEFT_PACKAGE_DELIMITER,
			inputProducts.length() - WITHOUT_RIGHT_PACKAGE_DELIMITER);
		String[] productInformation = removedPackageDelimiter.split(INFORMATION_DELIMITER);
		if (productInformation.length != NUMBER_OF_INPUT_COLUMN) {
			throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
		}
	}
}
