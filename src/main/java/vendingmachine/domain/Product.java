package vendingmachine.domain;

import java.util.Objects;

public class Product {

    private static final int STANDARD_PRICE = 100;

    private final String name;
    private final int price;
    private int remainAmount;

    public Product(String name, int price, int remainAmount) {
        checkPriceLargeThanStandardPrice(price);
        checkPriceDivisableByLeastCoin(price);
        this.name = name;
        this.price = price;
        this.remainAmount = remainAmount;
    }

    private static void checkPriceLargeThanStandardPrice(int price) {
        if (price < STANDARD_PRICE) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원 이상의 값이 들어와야 합니다.");
        }
    }

    private static void checkPriceDivisableByLeastCoin(int price) {
        if (price % Coin.leastCoin() != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어떠러져야 합니다.");
        }
    }

    public boolean isEqualsName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
