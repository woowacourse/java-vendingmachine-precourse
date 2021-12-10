package vendingmachine.exception;

public class InputException {

	private static final String INPUT_HAVE_SEMICOLON = "[ERROR] ;(세미콜론)을 이용해서 상품을 구별해야 합니다.";

	public static void checkSemicolon(String input) {
		if (!input.contains(";")) {
			throw new IllegalArgumentException(INPUT_HAVE_SEMICOLON);
		}
	}
}
