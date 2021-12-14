package vendingmachine.exception.dto;

public class ErrorResponse {
	private static String ERROR = "[ERROR] ";

	public static void of(String message) {
		System.out.println(ERROR + message);
	}
}
