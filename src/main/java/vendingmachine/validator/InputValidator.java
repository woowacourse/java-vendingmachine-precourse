package vendingmachine.validator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String ERR_INVALID_NUMBER = " 숫자만 입력해주세요";
    private static final String ERR_INVALID_LETTER = " 숫자와 글자만 허용됩니다.";
    private static final Pattern numericRegex = Pattern.compile("-?[0-9]+");

    public static void validateNumeric(String source) {
        if (!numericRegex.matcher(source).matches()) {
            throw new IllegalArgumentException(ERR_INVALID_NUMBER);
        }
    }

    public static void validateNonSpecialChar(String source) {
        if (!source.chars().allMatch(Character::isLetterOrDigit)) {
            throw new IllegalArgumentException(ERR_INVALID_LETTER);
        }
    }
}
