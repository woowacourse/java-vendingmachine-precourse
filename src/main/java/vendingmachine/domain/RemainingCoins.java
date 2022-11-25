package vendingmachine.domain;

import java.util.EnumMap;
import vendingmachine.CoinMaker;

public class RemainingCoins {
    private final Money money;
    private EnumMap<Coin, Integer> remainingCoins;

    public RemainingCoins(String input) {
        money = new Money(input);
        remainingCoins = CoinMaker.generateCoins(money);
    }

    public Money getMoney() {
        return money;
    }

    public EnumMap<Coin, Integer> getRemainingCoins() {
        return remainingCoins;
    }
}
