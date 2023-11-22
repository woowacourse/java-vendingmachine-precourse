package vendingmachine.domain;

import vendingmachine.utils.VendingMachineAmountValidator;

public class VendingMachineAmount {
    private final long amount;

    private VendingMachineAmount(long amount) {
        this.amount = amount;
    }

    public static VendingMachineAmount from(long amount) {
        VendingMachineAmountValidator.validateDividedByMinimumAmount(amount);
        return new VendingMachineAmount(amount);
    }
}
