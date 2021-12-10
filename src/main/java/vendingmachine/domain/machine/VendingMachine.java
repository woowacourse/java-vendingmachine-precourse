package vendingmachine.domain.machine;

import vendingmachine.domain.coin.CoinPocket;
import vendingmachine.domain.product.ProductStore;

public class VendingMachine {
    private int balance;
    private final ProductStore productStore;
    private final CoinPocket coinPocket;

    public static VendingMachine of(int balance) {
        return new VendingMachine(balance);
    }
    private VendingMachine(int balance) {
        this.balance = balance;
        this.productStore = ProductStore.getInstance();
        this.coinPocket = CoinPocket.getInstance();
    }

    // for test
    public boolean isEqualBalance(int balance) {
        return this.balance == balance;
    }
}
