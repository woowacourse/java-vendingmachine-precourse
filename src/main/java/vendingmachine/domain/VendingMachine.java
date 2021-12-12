package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private int holdingMoney;
    private int insertAmount;
    private CoinCase coinCase;
    private List<Product> productStorage;

    public VendingMachine() {
        this.holdingMoney = 0;
        this.insertAmount = 0;
        this.coinCase = new CoinCase();
        this.productStorage = new ArrayList<>();
    }

    public void setHoldingMoney(final int holdingMoney) {
        this.holdingMoney = holdingMoney;
    }

    public void initializeCoinCase() {
        coinCase.generateCoins(holdingMoney);
    }

    public HashMap<Coin, Integer> getHoldingCoins() {
        return coinCase.getHoldingCoins();
    }

    public void storeProduct(final Product product) {
        productStorage.add(product);
    }

    public void insertMoney(final int insertAmount) {
        this.insertAmount = insertAmount;
    }
}
