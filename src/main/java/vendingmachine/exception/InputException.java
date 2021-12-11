package vendingmachine.exception;

public class InputException {

	private static final String NOT_HAVE_SEMICOLON = "[ERROR] ;(세미콜론)을 이용해서 상품을 구별해야 합니다.";
	private static final String NOT_HAVE_BRACKET = "[ERROR] 입력 형식이 [콜라,1500,20];[사이다,1000,10] 또는 [콜라,1500,20] 이어야 합니다.";
	private static final String NOT_STOCK_FORM = "[ERROR] 수량은 1이상의 정수여야 합니다.";
	private static final String NOT_MONEY_FORM = "[ERROR] 금액은 10원으로 나누어 떨어져야 합니다.";
	private static final String NOT_NAME_FORM = "[ERROR] 상품 이름이 입력되지 않았습니다.";
	private static final String LESS_THAN_100 = "[ERROR] 상품 가격은 100원부터 시작해야 합니다.";
	private static final String NOT_ENOUGH_MONEY = "[ERROR] 해당 상품을 구매하기에는 금액이 부족합니다.";
	private static final String NOT_ENOUGH_INFO = "[ERROR] 상품 이름, 가격, 수량 모두 입력해야 합니다.";

	public static void printNotFoundSemicolonError() {
		throw new IllegalArgumentException(NOT_HAVE_SEMICOLON);
	}

	public static void printNotFoundBracketError() {
		throw new IllegalArgumentException(NOT_HAVE_BRACKET);
	}

	public static void printNotStockFormError() {
		throw new IllegalArgumentException(NOT_STOCK_FORM);
	}

	public static void printNotMoneyFormError() {
		throw new IllegalArgumentException(NOT_MONEY_FORM);
	}

	public static void printLessThanHundredError() {
		throw new IllegalArgumentException(LESS_THAN_100);
	}

	public static void printNotEnoughMoney() {
		throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
	}

	public static void printNotNameFormError() {
		throw new IllegalArgumentException(NOT_NAME_FORM);
	}

	public static void printNotEnoughInforror() {
		throw new IllegalArgumentException(NOT_ENOUGH_INFO);
	}
}
