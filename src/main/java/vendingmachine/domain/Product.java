package vendingmachine;

import vendingmachine.repository.InputAmount;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    private Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product of(String name, String price, String quantity) {
        checkName(name);
        checkPrice(price);
        checkQuantity(quantity);
        return new Product(name, Integer.parseInt(price), Integer.parseInt(quantity));
    }

    private static void checkQuantity(String quantity) {
        checkIsDigit(quantity);
        checkIsLessThanThresholdOfQuantity(quantity);
    }

    private static void checkIsLessThanThresholdOfQuantity(String quantity) {
        if (Integer.parseInt(quantity) < 1) {
            throw new IllegalArgumentException("[ERROR] 상품 수량은 1이상의 숫자로 입력해주세요.");
        }
    }

    private static void checkPrice(String price) {
        checkIsDigit(price);
        checkIsLessThanThresholdOfPrice(price);
        checkIsMultipleOfStandard(price);
    }

    private static void checkIsMultipleOfStandard(String price) {
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위이어야 합니다.");
        }
    }

    private static void checkIsLessThanThresholdOfPrice(String price) {
        if (Integer.parseInt(price) < 100) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상이어야 합니다.");
        }
    }

    private static void checkIsDigit(String price) {
        if (!price.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 상품 가격과 수량은 숫자로 입력해주세요.");
        }
    }

    private static void checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 상품 이름은 최소 한 글자 이상 입력해주세요.");
        }
    }

    public int getPrice() {
        return price;
    }

    public void reduceQuantity() {
        this.quantity--;
    }

    public boolean isOutOfStock() {
        return quantity == 0;
    }

    public boolean isOrLess(InputAmount inputAmount) {
        return price <= Integer.parseInt(inputAmount.toString());
    }

    public boolean isSameName(String productName) {
        return name.equals(productName);
    }
}
