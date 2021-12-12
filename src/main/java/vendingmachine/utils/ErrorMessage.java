package vendingmachine.utils;

public class ErrorMessage {
	public static final String COMMON = "[ERROR]";
	public static final String HOLDING_AMOUNT_NUM = "보유 금액은 숫자여야 합니다.";
	public static final String HOLDING_AMOUNT_MIN = "보유 금액은 10원 이상이여야 합니다.";
	public static final String HOLDING_AMOUNT_MAX = "보유 금액은 20억원 이하여야 합니다.";
	public static final String HOLDING_AMOUNT_DIVIDE = "보유 금액은 10원으로 나누어 떨어져야 합니다.";
	public static final String PRODUCTS_SPLIT = "상품목록은 세미콜론으로 끝날 수 없습니다.";
	public static final String PRODUCT_SPLIT = "개별 상품은 대괄호로 묶여 세미콜론으로 구분되어야 합니다.";
	public static final String PRODUCT_INPUT = "상품명, 가격, 수량이 입력되어야 상품 등록이 가능합니다.";
	public static final String PRODUCT_NAME_DUPLICATE = "상품명은 중복일 수 없습니다.";
	public static final String PRODUCT_AMOUNT_NUM = "상품가격은 숫자여야 합니다.";
	public static final String PRODUCT_AMOUNT_MIN = "상품가격은 100원 이상이여야 합니다.";
	public static final String PRODUCT_AMOUNT_MAX = "상품 가격은 20억원 이하여야 합니다.";
	public static final String PRODUCT_AMOUNT_DIVIDE = "상품 가격은 10원으로 나누어 떨어져야 합니다.";
	public static final String PRODUCT_COUNT_NUM = "상품 수량은 숫자여야 합니다.";
	public static final String PRODUCT_COUNT_MIN = "상품 수량은 1개 이상이여야 합니다.";
	public static final String PRODUCT_COUNT_MAX = "상품 수량은 20억개 이하여야 합니다.";
	public static final String ENTERED_AMOUNT_NUM = "투입금액은 수여야 합니다.";
	public static final String ENTERED_AMOUNT_MIN = "투입금액은 10원 이상이여야 합니다.";
	public static final String ENTERED_AMOUNT_MAX = "투입금액은 20억원 이하여야 합니다.";
	public static final String ENTERED_AMOUNT_DIVIDE = "투입금액은 10원으로 나누어 떨어져야 합니다.";
	public static final String PRODUCT_TO_BUY_EMPTY_PRODUCT = "입력한 상품명이 존재하지 않습니다.";
	public static final String PRODUCT_TO_BUY_EMPTY_COUNT = "입력한 상품은 품절되어 구매할 수 없습니다.";
	public static final String PRODUCT_TO_BUY_LACK = "현재 금액으로 입력한 상품을 구매할 수 없습니다.";
}
