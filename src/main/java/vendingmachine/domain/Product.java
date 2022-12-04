package vendingmachine.domain;

import static vendingmachine.utils.ErrorMessage.*;
import static vendingmachine.utils.MachineConst.MIN_PRODUCT_AMOUNT;

public class Product {

    private final String name;
    private final int amount;
    private int total;

    public Product(String name, int amount, int total) {

        validateAmount(amount);
        validateTotal(total);
        this.name = name;
        this.amount = amount;
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    private void validateAmount(int amount) {

        if (isNotDivide10(amount)) {
            throw new IllegalArgumentException(PRODUCT_AMOUNT_NOT_DIVIDE_10.getMessage());
        }

        if (isLessThanMinProductAmount(amount)) {
            throw new IllegalArgumentException(PRODUCT_AMOUNT_LESS_THAN_100.getMessage());
        }
    }

    private void validateTotal(int total) {

        if (isLessThan0(total)) {
            throw new IllegalArgumentException(PRODUCT_AMOUNT_LESS_THAN_0.getMessage());
        }
    }

    private boolean isLessThan0(int number) {
        return number <= 0;
    }

    private boolean isNotDivide10(int number) {
        return number % 10 != 0;
    }

    private boolean isLessThanMinProductAmount(int number) {
        return number < MIN_PRODUCT_AMOUNT.get();
    }

    public void consume() {

        if (isLessThan0(total)) {
            throw new IllegalArgumentException(NOT_EXIST_PRODUCT.getMessage());
        }

        this.total--;
    }
}
