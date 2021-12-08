package vendingmachine.exception.dto;

public class ErrorResponse {
	public static String of(String message) {
		return "[ERROR] " + message;
	}
}
