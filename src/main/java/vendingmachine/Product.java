package vendingmachine;

import vendingmachine.message.ExceptionMessage;

public class Product {
    public static final int MIN_PRICE = 100;
    private final String name;
    private final int price;

    public Product(String name, int price) {
        validate(name, price);
        this.name = name;
        this.price = price;
    }

    private void validate(String name, int price) {
        validateName(name);
        validatePrice(price);
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE);
        }
        if (price % 10 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRODUCT_PRICE);
        }
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
