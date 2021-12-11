package vendingmachine.domain;

import static vendingmachine.util.Validator.*;

public class MoneyBill {
    private int amount;

    public MoneyBill(int amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    private void validateMoney(int amount) {
        try {
            validateNonNegative(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isZero() {
        return this.amount == 0;
    }
}
