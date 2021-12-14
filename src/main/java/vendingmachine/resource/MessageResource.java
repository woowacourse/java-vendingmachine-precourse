package vendingmachine.resource;

public class MessageResource {
	public static final String INPUT_HAVE_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_PRODUCTS_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";
	public static final String INPUT_AMOUNT_MESSAGE = "\n투입 금액을 입력해 주세요.";

	public static final String OUTPUT_INPUT_CURRENT_AMOUNT = "\n투입 금액: %d원\n";
	public static final String OUTPUT_CHANGES = "%d원 - %d개\n";
	public static final String OUTPUT_VENDINGMACHINE_HAVE_COINS = "\n자판기가 보유한 동전";
	public static final String OUTPUT_CHANGES_TEXT = "잔돈";
	public static final String OUTPUT_NO_MONEY = "모든 금액을 소진 하셨습니다.";

	public static final String ERROR_AMOUNT_IS_NOT_NUMERIC = "[ERROR] 금액은 숫자여야 합니다.";
	public static final String ERROR_AMOUNT_IS_NOT_POSITIVE_INT = "[ERROR] 금액은 0원 보다 커야 합니다.";
	public static final String ERROR_IS_NOT_COIN_TYPE_EXIST = "[ERROR] 해당 코인 타입이 존재하지 않습니다.";
	public static final String ERROR_INPUT_PRODUCT_NOT_VALID = "[ERROR] 상품명,가격,수량이 올바른 형식이 아닙니다.";
	public static final String ERROR_PRODUCT_NOT_SQUARE_BRACKETS = "[ERROR] 상품입력 형식이 잘못 되었습니다.";
	public static final String ERROR_PRODUCT_PRICE_NOT_VALID = "[ERROR] 상품 가격은 100원부터 시작하고 10으로 나누어 떨어져야 합니다.";
	public static final String ERROR_PRODUCT_NAME_LENGTH_NOT_ZERO = "[ERROR] 상품 이름은 1글자 이상이어야 합니다.";
	public static final String ERROR_PRODUCT_NAME_DUPLICATED = "[ERROR] 해당 상품명은 이미 등록되어 있습니다.";
	public static final String ERROR_NUMBER_IS_NOT_POSITIVE_INT = "[ERROR] 0보다 큰 정수여야 합니다.";
	public static final String ERROR_NOT_FOUND_PRODUCT_NAME = "[ERROR] 해당 상품은 존재하지 않습니다.";
}
