package vendingmachine.util.validator;

import java.util.regex.Pattern;
import vendingmachine.util.ExceptionMessage;

public abstract class Validator {

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    public static final int MIN_UNIT = 10;

    abstract void validate(String input) throws IllegalArgumentException;


    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage(), exception);
        }
    }

    void validateUnit(String machineMoney) {
        if (Integer.parseInt(machineMoney) % MIN_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT.getMessage());
        }
    }

}