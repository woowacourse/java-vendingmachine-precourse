package vendingmachine.resource;

public class MessageResource {
	public static final String INPUT_HAVE_AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_PRODUCTS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";

	public static final String OUTPUT_INPUT_CURRENT_AMOUNT = "투입 금액: %d원";
	public static final String OUTPUT_CHANGES = "%d원 - %d개";

	public static final String ERROR_AMOUNT_IS_NUMERIC = "[ERROR] 금액은 숫자여야 합니다.";
}
