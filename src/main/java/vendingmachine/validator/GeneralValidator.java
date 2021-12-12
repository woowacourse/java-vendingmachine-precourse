package vendingmachine.validator;

public class GeneralValidator {

    private static final String ERR_HEADER = "[ERROR]";
    private static final String ERR_INVALID_NUMBER = ERR_HEADER + " 숫자만 입력해주세요";

    public static void validateNumeric(String source) {
        if (!source.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERR_INVALID_NUMBER);
        }
    }
}
