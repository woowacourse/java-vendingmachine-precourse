package vendingmachine.resource;

public class MessageResource {
	public static final String INPUT_HAVE_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static final String OUTPUT_INPUT_CURRENT_AMOUNT = "투입 금액: %d원";
	public static final String OUTPUT_CHANGES = "%d원 - %d개\n";

	public static final String ERROR_AMOUNT_IS_NOT_NUMERIC = "[ERROR] 금액은 숫자여야 합니다.";
	public static final String ERROR_AMOUNT_IS_NOT_POSITIVE_INT = "[ERROR] 금액은 0보다 큰 정수여야 합니다.";
	public static final String ERROR_AMOUNT_IS_NOT_VALID = "[ERROR] 금액이 유효하지 않습니다.";
	public static final String ERROR_IS_NOT_COIN_TYPE_EXIST = "[ERROR] 해당 코인 타입이 존재하지 않습니다.";
	public static final String ERROR_INPUT_PRODUCT_NOT_VALID = "[ERROR] 상품명,가격,수량이 올바른 형식이 아닙니다.";
	public static final String ERROR_PRODUCT_NOT_SQUARE_BRACKETS = "[ERROR] 상품입력 형식이 잘못 되었습니다.";
	public static final String ERROR_PRODUCT_PRICE_NOT_VALID = "[ERROR] 상품 가격은 100원부터 시작하고 10으로 나누어 떨어져야 합니다.";
	public static final String ERROR_PRODUCT_COUNT_IS_NOT_POSITIVE_INT = "[ERROR] 상품 수량은 0보다 커야 합니다.";
}
