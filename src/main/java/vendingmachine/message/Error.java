package vendingmachine.message;

import vendingmachine.model.Product;

public class Error {
	public static final String NOT_ONLY_NUMS = "[ERROR] 숫자만 입력할 수 있습니다.";
	public static final String NOT_ONLY_NUMS_IN_PRICE = "[ERROR] 가격은 숫자만 입력할 수 있습니다.";
	public static final String NOT_ONLY_NUMS_IN_STOCK = "[ERROR] 재고는 숫자만 입력할 수 있습니다.";
	public static final String LESS_THEN_MINIMUM_PRICE = "[ERROR] 가격은 최소 " + Product.MINIMUM_PRICE + "원 이어야 합니다.";
	public static final String WRONG_PRICE_UNIT = "[ERROR] 가격은 " + Product.MINIMUM_PRICE_UNIT + "원 단위여야 합니다.";
	public static final String DUPLICATED_PRODUCT_NAME = "[ERROR] 중복된 상품 이름이 있습니다";
	public static final String NO_SUCH_PRODUCT_EXIST = "[ERROR] 존재하지 않는 상품명입니다.";
}
