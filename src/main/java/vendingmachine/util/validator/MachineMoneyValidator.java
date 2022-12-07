package vendingmachine.util.validator;

import vendingmachine.util.Util;

public class MachineMoneyValidator extends Validator {


    @Override
    public void validate(String input) throws IllegalArgumentException {
        String machineMoney = Util.removeSpace(input);
        validateNumeric(machineMoney);
        validateRange(machineMoney);
        validateUnit(machineMoney);
    }

}
