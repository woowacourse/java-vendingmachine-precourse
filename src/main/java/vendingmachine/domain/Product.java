package vendingmachine.domain;

import java.util.Objects;
import vendingmachine.exception.ProductLeastPriceException;
import vendingmachine.exception.ProductNonRemainAmountException;
import vendingmachine.exception.ProductNotDivisableException;
import vendingmachine.exception.ProductNotEnoughMoneyException;

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
            throw new ProductLeastPriceException();
        }
    }

    private static void checkPriceDivisableByLeastCoin(int price) {
        if (price % Coin.leastCoin() != 0) {
            throw new ProductNotDivisableException();
        }
    }

    public boolean isEqualsName(String name) {
        return this.name.equals(name);
    }

    public int purchaseProduct(Money money) {
        checkRemainAmount();
        checkCanPurchaseMoney(money);
        remainAmount--;
        return price;
    }

    private void checkRemainAmount() {
        if (remainAmount <= 0) {
            throw new ProductNonRemainAmountException();
        }
    }

    private void checkCanPurchaseMoney(Money money) {
        if (!isPurchasable(money)) {
            throw new ProductNotEnoughMoneyException();
        }
    }

    public boolean isPurchasable(Money money) {
        return money.currentMoney() > price;
    }

    public boolean isPurchasable() {
        return remainAmount != 0;
    }

    public int price() {
        return price;
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
