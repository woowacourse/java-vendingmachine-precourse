package vendingmachine.util.validator;

import vendingmachine.util.Util;

public class MachineMoneyValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
        validateUnit(input);
    }

}
