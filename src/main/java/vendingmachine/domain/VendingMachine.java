package vendingmachine.domain;

import java.util.List;
import java.util.Map;
import vendingmachine.strategy.CoinCreateStrategy;
import vendingmachine.strategy.RandomCoinCreateStrategy;

public class VendingMachine {

    private final Coins coins;
    private final Products products;
    private final Money remainMoney = Money.init();

    public VendingMachine(Coins coins, Products products) {
        this.coins = coins;
        this.products = products;
    }

    public static VendingMachine createRandomVendingMachineByMoney(Money money) {
        CoinCreateStrategy coinCreateStrategy = new RandomCoinCreateStrategy();
        return new VendingMachine(Coins.createByMoney(money, new RandomCoinCreateStrategy()), Products.init());
    }

    public void putProducts(List<Product> products) {
        this.products.putProducts(products);
    }

    public Map<Coin, Integer> currentRemainCoins() {
        return coins.currentRemainCoins();
    }

    public void chargeMoney(Money money) {
        remainMoney.chargeMoney(money);
    }

    public boolean isPurchasable() {
        return products.isExistPurchasableProduct() && products.isPurchasableMinimumPriceProduct(remainMoney);
    }

    public Map<Coin, Integer> changeCoins() {
        return coins.changeCoins(remainMoney);
    }
}
