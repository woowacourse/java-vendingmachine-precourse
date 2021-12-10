package vendingmachine.exception;

public class InputException {

	private static final String INPUT_HAVE_SEMICOLON = "[ERROR] ;(세미콜론)을 이용해서 상품을 구별해야 합니다.";
	private static final String INPUT_HAVE_BRACKET = "[ERROR] 개별 상품은 [](대괄호)로 묶어야 합니다.";

	public static void checkSemicolon(String input) {
		if (!input.contains(";")) {
			throw new IllegalArgumentException(INPUT_HAVE_SEMICOLON);
		}
	}

	public static void checkBracket(String input) {
		if (input.charAt(0) != '[' || input.charAt(input.length() - 1) != ']') {
			throw new IllegalArgumentException(INPUT_HAVE_BRACKET);
		}
	}

}
