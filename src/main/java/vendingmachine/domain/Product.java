package vendingmachine.domain;

import static vendingmachine.utils.ErrorMessage.*;

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

        if (isLessThen100(amount)) {
            throw new IllegalArgumentException(PRODUCT_AMOUNT_LESS_THAN_100.getMessage());
        }
    }

    private void validateTotal(int total) {
        if (isLessThen0(total)) {
            throw new IllegalArgumentException(PRODUCT_AMOUNT_LESS_THAN_0.getMessage());
        }
    }

    private boolean isLessThen0(int number) {
        return number < 0;
    }

    private boolean isLessThen100(int number) {
        return number < 100;
    }

    private boolean isNotDivide10(int number) {
        return number % 10 != 0;
    }

    public void consume() {
        if (isLessThen0(total)) {
            throw new IllegalArgumentException(NOT_EXIST_PRODUCT.getMessage());
        }
        this.total--;
    }
}
