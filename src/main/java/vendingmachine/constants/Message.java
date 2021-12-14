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

	public static final String ANSWER_POSSESSION_COIN = "\n자판기가 보유한 동전";
	public static final String ANSWER_INPUT_COST = "\n투입 금액: ";
	public static final String ANSWER_CHANGE_COIN = "잔돈";

	public static final String ERROR_NOT_ENOUGH_STOCK = "[ERROR] 재고가 없어서 주문을 할 수 없습니다.";
	public static final String ERROR_NOT_ENOUGH_MONEY = "[ERROR] 해당 상품을 구매하기엔 보유 금액이 부족합니다.";
	public static final String ERROR_NO_ITEM_NAME_EXIST = "[ERROR] 해당 이름을 가진 제품은 존재하지 않습니다.";
	public static final String ERROR_IS_NOT_INTEGER = "[ERROR] 정수가 아닙니다.";
	public static final String ERROR_IS_NOT_POSITIVE = "[ERROR] 입력은 0을 포함한 양의 정수여야 합니다.";
	public static final String ERROR_DUPLICATED_ADD_ITEM_NAME = "[ERROR] 중복된 제품 이름은 등록할 수 없습니다.";
	public static final String ERROR_INVALID_ADD_ITEMS_FORMAT = "[ERROR] 잘못된 상품 추가 형식입니다. [이름,가격,수량];[...] 형식으로 입력해주세요";
	public static final String ERROR_INVALID_ITEM_FORMAT = "[ERROR] 잘못된 상품 입력 형식입니다. [영어+한글+숫자 (10글자 제한), 양의 정수, 양의 정수] 의 형식이어야 합니다.";
	public static final String ERROR_INVALID_UNIT_NUMBER = "[ERROR] 가격, 보유동전, 투입 금액은 10으로 나눠 떨어져야 합니다.";
	public static final String ERROR_INVALID_ADD_ITEM_PRICE = "[ERROR] 0원의 상품을 등록할 수 없습니다.";
	public static final String ERROR_INVALID_INPUT_MONEY = "[ERROR] 금액을 투입하셔야 합니다.";
	public static final String ERROR_INVALID_ADD_ITEM_STOCK = "[ERROR] 0개를 상품을 등록할 수 없습니다.";

	private Message() {

	}
}
