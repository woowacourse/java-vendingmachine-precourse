package vendingmachine.exception;

public class InputException {

	private static final String NOT_HAVE_SEMICOLON = "[ERROR] ;(세미콜론)을 이용해서 상품을 구별해야 합니다.";
	private static final String NOT_HAVE_BRACKET = "[ERROR] 개별 상품은 [](대괄호)로 묶어야 합니다.";
	private static final String PREFIX = "[ERROR] 올바른 ";
	private static final String NOT_NUMBER = " 형식이 아닙니다.";

	public static void printNotFoundSemicolonError() {
		throw new IllegalArgumentException(NOT_HAVE_SEMICOLON);
	}

	public static void printNotFoundBracketError() {
		throw new IllegalArgumentException(NOT_HAVE_BRACKET);
	}

	public static void printNotNumberError(String target) {
		throw new IllegalArgumentException(PREFIX + target + NOT_NUMBER);
	}

}
