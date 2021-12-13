package vendingmachine.constants;

public class Message {
	public static final String WON = "원";
	public static final String SPACE = " - ";
	public static final String COUNT = "개";
	public static final String ENTER_LINE = "";
	public static final String ASK_POSSESSION = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String ASK_ITEM_REGISTRATION = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String ASK_INPUT_COST = "\n투입 금액을 입력해 주세요.";
	public static final String ASK_PURCHASING_ITEM_NAME = "구매할 상품명을 입력해 주세요.";
	public static final String POSSESSION_COIN = "\n자판기가 보유한 동전";
	public static final String INPUT_COST = "\n투입 금액: ";
	public static final String CHANGE_COIN = "잔돈";

	public static final String ERROR_IS_NOT_NUMBER = "[ERROR] 금액은 중간에 공백이 없는 양의 숫자여야 합니다";
	public static final String ERROR_EMPTY_INPUT = "[ERROR] 입력이 공백으로 이뤄져서는 안됩니다.";
	public static final String ERROR_INVALID_INPUT_UNIT = "[ERROR] 입력은 10으로 나눠 떨어져야 합니다.";
	public static final String ERROR_NOT_ENOUGH_STOCK = "[ERROR] 재고가 없어서 주문을 할 수 없습니다";
	public static final String ERROR_NOT_ENOUGH_MONEY = "[ERROR] 해당 상품을 구매하기엔 보유 금액이 부족합니다";
	public static final String ERROR_IS_DUPLICATED_ITEM_NAME = "[ERROR] 중복된 제품 이름입니다.";
	public static final String ERROR_INVALID_ITEM_ADDING_FORMAT = "[ERROR] 잘못된 상품 추가 형식입니다";
	public static final String ERROR_INVALID_ITEM_FORMAT = "[ERROR] 잘못된 상품 형식입니다";
	public static final String ERROR_INVALID_ITEM_NAME = "[ERROR] 해당 이름을 가진 제품은 존재하지 않습니다";
	public static final String ERROR_IS_NOT_INTEGER = "[ERROR] 0 또는 양의 정수 범위가 아닙니다.";
	public static final String ERROR_INVALID_ADD_ITEM_PRICE = "[ERROR] 0원의 상품음 등록하실 수 없습니다.";
	public static final String ERROR_INVALID_ADD_ITEM_STOCK = "[ERROR] 0개를 등록하실 수 없습니다.";

	private Message() {

	}
}
