package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "상품명과 일치하는 상품이 존재하지 않습니다.";
    private static final String NOT_ENOUGH_INSERT_AMOUNT_ERROR_MESSAGE = "투입 금액이 부족합니다.";
    private static final String PRODUCT_SOLD_OUT_ERROR_MESSAGE = "해당 상품의 재고가 없습니다. 다른 상품을 선택해 주세요.";

    private int insertAmount;
    private CoinCase coinCase;
    private List<Product> productStorage;

    public VendingMachine() {
        this.insertAmount = 0;
        this.coinCase = new CoinCase();
        this.productStorage = new ArrayList<>();
    }

    public void initializeCoinCase(final int holdingAmount) {
        coinCase.generateCoins(holdingAmount);
    }

    public HashMap<Coin, Integer> getHoldingCoins() {
        return coinCase.getHoldingCoins();
    }

    public int getHoldingAmount() {
        return coinCase.getHoldingAmount();
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
            if (product.isBuyAble(insertAmount))
                return true;
        }
        return false;
    }

    public Product findProduct(final String productName) {
        return productStorage.stream()
            .filter(product -> product.getName().equals(productName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_FOUND_ERROR_MESSAGE));
    }

    public void buyProduct(final Product targetProduct) {
        if (targetProduct.isBuyAble(insertAmount)) {
            pay(targetProduct.getPrice());
            targetProduct.pullOut();
            return;
        }
        if (targetProduct.getPrice() > insertAmount) {
            throw new IllegalArgumentException(NOT_ENOUGH_INSERT_AMOUNT_ERROR_MESSAGE);
        }
        if (targetProduct.getStock() == 0) {
            throw new IllegalArgumentException(PRODUCT_SOLD_OUT_ERROR_MESSAGE);
        }
    }

    private void pay(final int price) {
        insertAmount -= price;
    }
}
