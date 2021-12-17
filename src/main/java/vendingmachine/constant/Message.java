package vendingmachine.constant;

import vendingmachine.model.Coin;

public class Message {

	public static final String EMPTY = "";
	public static final String SPACE = " ";
	public static final String TAP = "	";
	public static final String COLON = " : ";

	public static final String WON = "원";
	public static final String EA = "개";

	public static final String INPUT_HOlDING_SUM = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_STOCK = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INPUT_INSERTING_SUM = "투입 금액을 입력해 주세요.";
	public static final String INPUT_NAME = "구매할 상품명을 입력해 주세요.";

	public static final String OUTPUT_HOLDING_SUM = "자판기가 보유한 동전";
	public static final String OUTPUT_INSERTING_SUM = "투입 금액: ";
	public static final String OUTPUT_CHANGE = "잔돈";

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_NOT_POSITIVE_NUMBER = Coin.minAmount() + "원 이상의 정수를 입력해 주세요.";
	public static final String ERROR_EXCEED_INTEGER = Integer.MAX_VALUE + "이하를 입력해 주세요.";
	public static final String ERROR_DIVISIBLE_NUMBER = Coin.minAmount() + "원 단위의 정수를 입력해 주세요.";
	public static final String ERROR_INPUT_IS_EMPTY = "아무것도 입력되지 않았습니다.";
	public static final String ERROR_CONTAINS_SPACE = "공백이 포함될 수 없습니다.";
	public static final String ERROR_CONTAINS_TAP = "탭이 포함될 수 없습니다.";
	public static final String ERROR_LENGTH_ZERO = "1자 이상을 입력해주세요";
	public static final String ERROR_THE_NUMBER_OF = "개를 입력해주세요.";
	public static final String ERROR_NOT_BRACKET = "개별 상품은 " + Rule.BRACKET + "로 묶어야합니다.";
	public static final String ERROR_LESS_THAN_MIN_PRICE = "가격은 최소 " + Rule.MIN_PRICE + WON + "이상이어야 합니다.";
	public static final String ERROR_PRODUCT_DUPLICATION = "상품명은 중복될 수 없습니다.";
	public static final String ERROR_NON_EXISTENT_PRODUCT = "없는 상품입니다.";
	public static final String ERROR_INSERTING_SUM_IS_LESS_PRICE = "투입 금액이 부족합니다.";
	public static final String ERROR_EXCEED_MAX_LENGTH = "자 이하여야합니다.";
	public static final String ERROR_DUPLICATION = "중복이 없어야 합니다.";

	public static String toString(int amount, int count) {
		return amount + WON + " - " + count + EA;
	}
}
