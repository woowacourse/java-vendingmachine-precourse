package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

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
}
