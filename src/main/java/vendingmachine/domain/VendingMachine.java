package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "상품명과 일치하는 상품이 존재하지 않습니다.";
    private static final String NOT_ENOUGH_INSERT_AMOUNT_ERROR_MESSAGE = "투입 금액이 부족합니다.";
    private static final String PRODUCT_SOLD_OUT_ERROR_MESSAGE = "해당 상품의 재고가 없습니다. 다른 상품을 선택해 주세요.";

    private int insertAmount;
    private final CoinCase coinCase;
    private final List<Product> productStorage;

    public VendingMachine() {
        this.insertAmount = 0;
        this.coinCase = new CoinCase();
        this.productStorage = new ArrayList<>();
    }

    public void initializeCoinCase(final int holdingAmount) {
        coinCase.generateCoins(holdingAmount);
    }

    public int getNumberOfHoldingCoins(final Coin coin) {
        return coinCase.getNumberOfHoldingCoins(coin);
    }

    public int getInsertAmount() {
        return insertAmount;
    }

    public void storeProduct(final Product product) {
        productStorage.add(product);
    }

    public void insertMoney(final int insertAmount) {
        this.insertAmount = insertAmount;
    }

    public boolean isBuyAbleProductRemain() {
        for (Product product : productStorage) {
            if (product.isBuyAble(insertAmount) && !product.isSoldOut()) {
                return true;
            }
        }
        return false;
    }

    public Product findProduct(final String productName) {
        return productStorage.stream()
            .filter(product -> product.matchName(productName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_FOUND_ERROR_MESSAGE));
    }

    public void buyProduct(final Product targetProduct) {
        if (!targetProduct.isBuyAble(insertAmount)) {
            throw new IllegalArgumentException(NOT_ENOUGH_INSERT_AMOUNT_ERROR_MESSAGE);
        }
        if (targetProduct.isSoldOut()) {
            throw new IllegalArgumentException(PRODUCT_SOLD_OUT_ERROR_MESSAGE);
        }
        pay(targetProduct.getPrice());
        targetProduct.pullOut();
    }

    private void pay(final int price) {
        insertAmount -= price;
    }

    public void returnCoin(final Coin coin) {
        coinCase.pullOut(coin);
        insertAmount -= coin.getAmount();
    }
}
