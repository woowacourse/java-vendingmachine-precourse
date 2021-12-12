package vendingmachine.validator;

import java.util.List;

public class ProductValidator {
	static final String MSG_INVALIDATE_FORMAT_ERROR = "[ERROR] 상품명, 가격, 수량은 대괄호로 감싸져 있어야 한다.";
	static final String MSG_INFO_MISS_ERROR = "[ERROR] 상품명, 가격, 수량을 입력해야 한다.";
	static final String MSG_EMPTY_NAME_ERROR = "[ERROR] 상품명은 공백일 수 없다.";
	static final String PRODUCT_INPUT_PREFIX = "[";
	static final String PRODUCT_INPUT_SUFFIX = "]";
	static final int PRODUCT_INFO_LENGTH = 3;

	static public void validateFormat(String productInput) {
		if (!(productInput.startsWith(PRODUCT_INPUT_PREFIX)
			&& productInput.endsWith(PRODUCT_INPUT_SUFFIX))) {
			throw new IllegalArgumentException(MSG_INVALIDATE_FORMAT_ERROR);
		}
	}

	static public void validateInfoMiss(List<String> productInput) {
		if (productInput.size() != PRODUCT_INFO_LENGTH) {
			throw new IllegalArgumentException(MSG_INFO_MISS_ERROR);
		}
	}

	static public void validateIsEmptyName(String productName) {
		if (productName.equals("")) {
			throw new IllegalArgumentException(MSG_EMPTY_NAME_ERROR);
		}
	}
}
