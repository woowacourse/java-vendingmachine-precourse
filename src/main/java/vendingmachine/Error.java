package vendingmachine;

public class Error {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static final String ONLY_NUMBER = "금액은 숫자여야 합니다.";
	public static final String OVER_ZERO = "금액은 0이상의 숫자여야 합니다.";
	public static final String DIVIDED_BY_TEN = "금액은 10원 단위로 입력해야 합니다.";

	public static final String PRODUCT_EMPTY = "상품 정보를 입력해주세요.";
	public static final String PRODUCTS_COVER_TEXT = "상품의 정보는 대괄호([])를 감싼 형식으로 작성해주세요.";
	public static final String PRODUCT_SPLIT_TEXT = "상품의 정보는 컴마(,)로 구분하여 '[상품명,가격,수량]'의 형식으로 작성해주세요.";
	public static final String PRODUCT_NAME_EMPTY = "상품의 이름 정보를 입력해주세요.";
	public static final String PRODUCT_NAME_DUPLICATE = "이름이 중복되는 상품이 존재합니다. 중복되지 않도록 입력해주세요.";
	public static final String PRODUCT_PRICE_ONLY_NUMBER = "상품 가격은 숫자여야 합니다.";
	public static final String PRODUCT_PRICE_MINIMUM = "상품 가격은 100원 이상이어야 합니다.";
	public static final String PRODUCT_PRICE_DIVIDED_BY_TEN = "금액은 10원 단위로 입력해야 합니다.";
	public static final String PRODUCT_QUANTITY_ONLY_NUMBER = "상품 개수는 숫자여야 합니다.";
	public static final String PRODUCT_QUANTITY_OVER_ZERO = "상품 개수는 0이상의 숫자여야 합니다.";

	public static final String MONEY_NUMBER = "투입 금액은 숫자여야 합니다.";
	public static final String MONEY_OVER_ZERO = "투입 금액은 0이상의 숫자여야 합니다.";
	public static final String MONEY_DIVIDED_BY_TEN = "투입 금액은 10원 단위로 입력해야 합니다.";

	public static final String SELECTED_PRODUCT_EMPTY = "구매할 상품명을 입력해 주세요.";

	public static final String NOT_EXIST_PRODUCT_NAME = "존재하지 않는 상품입니다. 다른 상품을 선택해주세요.";
	public static final String NOT_EXIST_PRODUCT = "상품의 재고가 소진되었습니다. 다른 상품을 선택해주세요.";
	public static final String LOWER_MONEY = "금액이 부족합니다.";

	// TODO: 모든 Exception 에러 IllegalArgumentException 로 변경하기
	public static void error(String str) {
		throw new IllegalArgumentException(ERROR_PREFIX + str);
	}
}
