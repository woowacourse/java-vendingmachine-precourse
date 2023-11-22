package vendingmachine.domain;

import vendingmachine.constants.Constants;

public class Product {

    private static final int MIN_PRICE = 100;
    private static final int PRICE_UNIT = 10;

    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        validatePrice(price);
        this.price = price;
        this.quantity = quantity;
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(
                    String.format("%s 상품 가격은 %d원 이상이어야 합니다.", Constants.ERROR_PREFIX, MIN_PRICE));
        }
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("%s 상품 가격은 %d원 단위만 가능합니다.", Constants.ERROR_PREFIX, PRICE_UNIT));
        }
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public boolean isPriceGreaterThan(int amount) {
        return price > amount;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public int getPrice() {
        return price;
    }
}
