package vendingmachine.configuration;

import vendingmachine.controller.InputVendingMachineController;
import vendingmachine.controller.OutPutVendingMachineController;
import vendingmachine.system.validation.Validation;
import vendingmachine.system.validation.ValidationImplementation;
import vendingmachine.util.InputParsingUtility;
import vendingmachine.util.RandomUtility;

public class DependencyInjectionContainer {
    public InputVendingMachineController inputVendingMachineController() {
        return InputVendingMachineController.getInstance();
    }

    public OutPutVendingMachineController outPutVendingMachineController() {
        return OutPutVendingMachineController.getInstance();
    }

    public Validation validation() {
        return ValidationImplementation.getInstance();
    }

    public RandomUtility randomUtility() {
        return RandomUtility.getInstance();
    }

    public InputParsingUtility inputParsingUtility() {
        return InputParsingUtility.getInstance();
    }
}
