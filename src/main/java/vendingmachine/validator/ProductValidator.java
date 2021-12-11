package vendingmachine.validator;

public class ProductValidator {
	static final String MSG_INVALIDATE_FORMAT_ERROR = "[ERROR] 상품명, 가격, 수량은 대괄호로 감싸져 있어야 한다.";
	static final String PRODUCT_INPUT_PREFIX = "[";
	static final String PRODUCT_INPUT_SUFFIX = "]";

	static public void checkFormat(String productInput) {
		if (!(productInput.startsWith(PRODUCT_INPUT_PREFIX)
			&& productInput.endsWith(PRODUCT_INPUT_SUFFIX))) {
			throw new IllegalArgumentException(MSG_INVALIDATE_FORMAT_ERROR);
		}
	}
}
