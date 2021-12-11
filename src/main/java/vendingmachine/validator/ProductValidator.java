package vendingmachine.validator;

public class ProductValidator {
	static final String MSG_INVALIDATE_FORMAT_ERROR = "[ERROR] 상품명, 가격, 수량은 대괄호로 감싸져 있어야 한다.";
	static final String MSG_INFO_MISS_ERROR = "[ERROR] 상품명, 가격, 수량을 입력해야 한다.";
	static final String PRODUCT_INPUT_PREFIX = "[";
	static final String PRODUCT_INPUT_SUFFIX = "]";
	static final String PRODUCT_INFO_REGEX = ",";
	static final int PRODUCT_INFO_LENGTH = 3;

	static public void checkFormat(String productInput) {
		if (!(productInput.startsWith(PRODUCT_INPUT_PREFIX)
			&& productInput.endsWith(PRODUCT_INPUT_SUFFIX))) {
			throw new IllegalArgumentException(MSG_INVALIDATE_FORMAT_ERROR);
		}
	}

	static public void checkInfoMiss(String productInput) {
		String [] productInfo = productInput.split(PRODUCT_INFO_REGEX);
		if (productInfo.length != PRODUCT_INFO_LENGTH) {
			throw new IllegalArgumentException(MSG_INFO_MISS_ERROR);
		}
	}
}
