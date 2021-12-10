package vendingmachine.exception;

public class InputException {

	private static final String INPUT_HAVE_SEMICOLON = "[ERROR] ;(세미콜론)을 이용해서 상품을 구별해야 합니다.";
	private static final String INPUT_HAVE_BRACKET = "[ERROR] 개별 상품은 [](대괄호)로 묶어야 합니다.";
	private static final String INPUT_IS_NUMBER = "[ERROR] 올바른 금액 형식이 아닙니다.";

	public static void printNotFoundSemicolonError() {
		throw new IllegalArgumentException(INPUT_HAVE_SEMICOLON);
	}

	public static void printNotFoundBracketError() {
		throw new IllegalArgumentException(INPUT_HAVE_BRACKET);
	}

	public static void printNotNumberError() {
		throw new IllegalArgumentException(INPUT_IS_NUMBER);
	}

}
