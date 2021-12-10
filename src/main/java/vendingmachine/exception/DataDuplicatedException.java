package vendingmachine.exception;

public class DataDuplicatedException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "입력 데이터에서 중복이 발견되었습니다.";

	public DataDuplicatedException() {
		super(ERROR_MESSAGE);
	}
}
