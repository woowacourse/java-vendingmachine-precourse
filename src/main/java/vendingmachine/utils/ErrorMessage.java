package vendingmachine.utils;

public class ErrorMessage {
	public static final String NO_COIN_MESSAGE = "해당 금액의 코인을 찾을 수 없습니다.";
	public static final String CAN_NOT_BUY_PRODUCT_MESSAGE = "상품이 투입금액보다 비쌉니다.";
	public static final String INVALID_PRODUCT_MESSAGE = "해당 상품이 존재하지 않습니다.";
	public static final String INVALID_TYPE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 숫자만 가능합니다.";
	public static final String INVALID_RANGE_OF_HOLDING_AMOUNT_MESSAGE = "보유 금액은 10으로 나누어 떨어져야 합니다.";
	public static final String INVALID_NUMBER_OF_PRODUCT_MESSAGE = "상품을 1개 이상 입력하세요.";
	public static final String INVALID_PATTERN_OF_PRODUCT_MESSAGE = "[상품명,가격,수량] 형식으로 입력하세요.";
	public static final String INVALID_UNIT_OF_PRODUCT_AMOUNT_MESSAGE = "상품 가격은 10으로 나누어 떨어져야 합니다.";
	public static final String INVALID_RANGE_OF_PRODUCT_AMOUNT_MESSAGE = "상품 가격은 100원 이상이어야 합니다.";
	public static final String INVALID_NUMBER_OF_PRODUCT_AMOUNT_MESSAGE = "상품 수량은 1개 이상이어야 합니다.";
	public static final String INVALID_TYPE_OF_INPUT_AMOUNT_MESSAGE = "투입 금액은 숫자여야 합니다.";
}
