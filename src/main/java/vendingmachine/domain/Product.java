package vendingmachine.domain;

import static vendingmachine.util.StringConversionUtil.parseInt;

import java.util.List;
import java.util.Objects;
import vendingmachine.exception.ProductContentSizeException;
import vendingmachine.exception.ProductLeastPriceException;
import vendingmachine.exception.ProductNameEmptyException;
import vendingmachine.exception.ProductNonRemainAmountException;
import vendingmachine.exception.ProductNotDivisableException;
import vendingmachine.exception.ProductNotEnoughMoneyException;

public class Product {

    private static final int STANDARD_PRICE = 100;
    private static final String BLANK_NAME = "";

    private static final int PRODUCT_CONTANT_SIZE = 3;
    private static final int PRODUCT_NAME_INDEX = 0;
    private static final int PRODUCT_PRICE_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;

    private final String name;
    private final int price;
    private int remainAmount;

    public Product(String name, int price, int remainAmount) {
        checkNameIsEmpty(name);
        checkPriceLargeThanStandardPrice(price);
        checkPriceDivisableByLeastCoin(price);
        this.name = name;
        this.price = price;
        this.remainAmount = remainAmount;
    }

    private static void checkNameIsEmpty(String name) {
        if (Objects.isNull(name) || name.equals(BLANK_NAME)) {
            throw new ProductNameEmptyException();
        }
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

    public static Product crearteProduct(List<String> contents) {
        checkContentSize(contents);
        return new Product(contents.get(PRODUCT_NAME_INDEX), parseInt(contents.get(PRODUCT_PRICE_INDEX)),
            parseInt(contents.get(PRODUCT_AMOUNT_INDEX)));
    }

    private static void checkContentSize(List<String> contents) {
        if (contents.size() != PRODUCT_CONTANT_SIZE) {
            throw new ProductContentSizeException();
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
