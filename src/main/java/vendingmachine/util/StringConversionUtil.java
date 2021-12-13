package vendingmachine.util;

public class StringConversionUtil {

    private static final String PARSE_INTEGER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_INTEGER_FORMAT_ERROR_MESSAGE);
        }
    }
}
