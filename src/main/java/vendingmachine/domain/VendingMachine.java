package vendingmachine.domain;

import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.products.Products;

public class VendingMachine {

    private final Money money;
    private final Coins coins;
    private final Products products;

    private VendingMachine(Money money, Coins coins, Products products) {
        this.money = money;
        this.coins = coins;
        this.products = products;
    }

    public static VendingMachine of(Money money, Coins coins, Products products) {
        return new VendingMachine(money, coins, products);
    }
}
