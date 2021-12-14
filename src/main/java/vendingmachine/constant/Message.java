package vendingmachine.constant;

public final class Message {
	public static final String ERROR_NOT_FOUND_COIN_TYPE = "해당 금액을 찾을 수 없습니다.";
	public static final String ERROR_INVALID_PRICE_AND_QUANTITY_TYPE = "상품의 가격, 수량 입력이 잘못되었습니다.";
	public static final String ERROR_INVALID_PRICE = "상품의 가격은 100원 이상, 10원으로 나누어떨어져야합니다.";
	public static final String ERROR_NOT_ENOUGH_MONEY = "금액이 부족합니다.";
	public static final String ERROR_INVALID_COIN = "유효하지 않은 금액입니다.";
	public static final String ERROR_NOT_NUMBER = "숫자만 입력해야합니다.";
	public static final String ERROR_SOLD_OUT_PRODUCT = "상품의 재고가 모두 소진되었습니다.";
	public static final String ERROR_INVALID_PRODUCT_INPUT_TYPE = "상품 정보 입력 형식을 다시 확인해주세요";
	public static final String ERROR_DUPLICATE_PRODUCT = "중복된 상품입니다.";
	public static final String ERROR_NO_PRODUCT = "존재하지 않는 상품입니다.";
	public static final String ERROR_NOT_FOUND_PRODUCT = "구매 가능한 상품이 없습니다.";
	public static final String ERROR = "[ERROR] ";
	public static final String INPUT_VENDING_MACHINE_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
	public static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
	public static final String CHECK_CURRENT_USER_MONEY = "투입 금액: ";
	public static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";
}
