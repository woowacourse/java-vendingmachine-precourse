package vendingmachine;

public class Constants {
	public static final char CHAR_ZERO = '0';
	public static final char CHAR_NINE = '9';
	public static final char CHAR_LEFT_BRACKET = '[';
	public static final char CHAR_RIGHT_BRACKET = ']';
	public static final int MIN_INPUT_MONEY = 10;
	public static final int MIN_PRICE = 100;
	public static final int INITIAL_COIN_COUNT = 0;
	public static final int ADD_COIN_COUNT = 1;
	public static final int COIN_COUNT_ZERO = 0;
	public static final int PRODUCT_COUNT_ZERO = 0;
	public static final int COIN_CONSUME_AMOUNT = 1;
	public static final int PRODUCT_NAME_INDEX = 0;
	public static final int PRODUCT_PRICE_INDEX = 1;
	public static final int PRODUCT_COUNT_INDEX = 2;
	public static final int PRODUCT_ELEMENT_SIZE = 3;
	public static final int NON_BRACKET_INDEX = 1;
	public static final int BRACKET_INDEX = 0;
	public static final String STRING_SPACE = " ";
	public static final String EMPTY_STRING = "";
	public static final String STRING_ZERO = "0";
	public static final String STRING_WON = "원";
	public static final String STRING_DASH_WITH_SPACE = " - ";
	public static final String STRING_COUNT = "개";
	public static final String STRING_SEMICOLON = ";";
	public static final String STRING_COMMA = ",";
	public static final String MESSAGE_INPUT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String MESSAGE_PRINT_COINS = "\n자판기가 보유한 동전";
	public static final String MESSAGE_INPUT_PRODUCT = "\n상품명과 가격, 수량을 입력해 주세요.";
	public static final String MESSAGE_USER_MONEY = "\n투입 금액: ";
	public static final String MESSAGE_ORDER_PRODUCT = "구매할 상품명을 입력해 주세요.";
	public static final String MESSAGE_CHANGE = "잔돈";
	public static final String ERROR = "[ERROR]";
	public static final String ERROR_STRING = ERROR + " 잘못된 문자열을 입력하셨습니다.";
	public static final String ERROR_PRODUCTS = ERROR + " 잘못된 상품 정보를 입력하셨습니다.";
	public static final String ERROR_INPUT_MONEY = ERROR + " 잘못된 금액을 입력하셨습니다.";
	public static final String MESSAGE_INPUT_USER_MONEY = "\n투입 금액을 입력해 주세요.";
}
