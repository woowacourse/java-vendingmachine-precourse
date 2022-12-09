package vendingmachine.exception;

public class IntConvertException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE_CONVERT_INT = "[ERROR] 입력값이 숫자가 아니거나 값의 범위를 초과했습니다.";

    public IntConvertException() {
        super(EXCEPTION_MESSAGE_CONVERT_INT);
    }
}
