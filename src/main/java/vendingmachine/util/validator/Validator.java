package vendingmachine.util.validator;

import java.util.regex.Pattern;
import vendingmachine.util.ExceptionMessage;

public abstract class Validator {

    private enum Value {
        MIN_RANGE(3), MAX_RANGE(20), MIN_UNIT(10);;

        private final int value;

        Value(int value) {
            this.value = value;
        }
    }

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

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

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < Value.MIN_RANGE.value || number > Value.MIN_RANGE.value) {
            throw new IllegalArgumentException();
        }
    }

    void validateUnit(String machineMoney) {
        if (Integer.parseInt(machineMoney) % Value.MIN_UNIT.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT.getMessage());
        }
    }


}