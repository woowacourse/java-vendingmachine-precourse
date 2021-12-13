package vendingmachine;

import java.util.Objects;

public class Product {
    private static final int MIN_PRICE = 100;
    private static final int MIN_DIVIDE= 10;
    private static final int VALID_REMAINDER = 0;

    private static final int EMPTY_QUANTITY = 0;
    private static final int DECREASE = 1;

    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        validateName(name);
        validatePrice(price);
        validateQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw ErrorMessage.INVALID_PRODUCT_NAME.getException();
        }
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw ErrorMessage.MIN_PRICE.getException();
        }
        if (price % MIN_DIVIDE != VALID_REMAINDER) {
            throw ErrorMessage.NOT_DIVISIBLE.getException();
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= EMPTY_QUANTITY) {
            throw ErrorMessage.INVALID_QUANTITY_.getException();
        }
    }

    public boolean isEqualToName(String name) {
        return this.name.equals(name);
    }

    public void processPurchasing(Order order) {
        this.quantity -= DECREASE;
        order.calculate(this.price);
    }

    public boolean isExistedProduct() {
        if (this.quantity > EMPTY_QUANTITY) {
            return true;
        }
        throw ErrorMessage.IMPOSSIBLE_BUY_PRODUCT.getException();
    }

    public boolean isPossibleBuyProduct(int holdingAmount) {
        return this.quantity > EMPTY_QUANTITY && price <= holdingAmount;
    }
}
