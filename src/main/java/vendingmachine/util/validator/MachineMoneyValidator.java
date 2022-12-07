package vendingmachine.util.validator;

import vendingmachine.util.ExceptionMessage;
import vendingmachine.util.Util;

public class MachineMoneyValidator extends Validator {
    private enum Value {
        MIN_UNIT(10);

        private final int value;

        Value(int value) {
            this.value = value;
        }
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String machineMoney = Util.removeSpace(input);
        validateNumeric(machineMoney);
        validateRange(machineMoney);
        validateUnit(machineMoney);
    }

    private static void validateUnit(String machineMoney) {
        if (Integer.parseInt(machineMoney) % Value.MIN_UNIT.value != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT.getMessage());
        }
    }
}
