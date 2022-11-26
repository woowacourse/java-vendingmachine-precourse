package vendingmachine;

import java.util.EnumMap;
import vendingmachine.domain.Coin;
import vendingmachine.domain.RemainingCoins;
import vendingmachine.domain.Stock;
import vendingmachine.domain.Stocks;
import vendingmachine.domain.UsersMoney;

public class VendingMachine {
    private final RemainingCoins remainingCoins;
    private final Stocks stocks;
    private final UsersMoney usersMoney;

    public VendingMachine(RemainingCoins remainingCoins, Stocks stocks, UsersMoney usersMoney) {
        this.remainingCoins = remainingCoins;
        this.stocks = stocks;
        this.usersMoney = usersMoney;
    }

    public boolean isPurchasable(Stock existingStock) {
        return stocks.exists(existingStock) && stocks.canAfford(usersMoney.getMoney(), existingStock);
    }

    public int getUsersMoney() {
        return usersMoney.getMoney();
    }

    public Stock checkStock(String userInput) {
        return stocks.getMatchingStock(userInput);
    }

    public void purchase(Stock existingStock) {
        stocks.purchaseStock(existingStock);
        usersMoney.buy(existingStock.getPrice());
    }

    public EnumMap<Coin, Integer> returnCoins() {
        return remainingCoins.giveChange(usersMoney.getMoney());
    }
}
