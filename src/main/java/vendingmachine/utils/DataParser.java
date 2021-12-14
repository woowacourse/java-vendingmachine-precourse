package vendingmachine.utils;

/**
 * String -> int 변환할 때 사용할 클래스
 * NumberFormatException catch 해서 IllegalArgumentException으로 바꿔서 던져준다.
 */
public class DataParser {
	public static int parseInt(String string, String errorMessage) {
		try {
			return Integer.parseInt(string.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
