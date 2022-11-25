package vendingmachine;

import java.util.EnumMap;

public class RemainingCoins {
    private final Money money;
    private EnumMap<Coin, Integer> remainingCoins;

    public RemainingCoins(String input) {
        money = new Money(input);
        remainingCoins = CoinMaker.generateCoins(money);
        System.out.print(remainingCoins);
    }

    public Money getMoney() {
        return money;
    }
}
