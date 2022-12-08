package vendingmachine.domain.coins;

import vendingmachine.domain.Money;

import java.util.EnumMap;
import java.util.List;

public class Coins {

    private static final int INITIAL_COIN_NUMBER = 0;

    private final EnumMap<Coin, Integer> coins;

    public Coins() {
        this.coins = initCoins();
    }

    public void makeRandomCoins(NumberGenerator numberGenerator, Money money) {
        List<Integer> coinAmounts = Coin.makeAmountList();
        int minAmount = Coin.findMinAmount();

        while (money.isUseMoney(minAmount)) {
            int number = numberGenerator.generate(coinAmounts);
            if (money.isUseMoney(number)) {
                money.useMoney(number);
                this.coins.put(Coin.of(number), this.coins.get(Coin.of(number)) + 1);
            }
            if (!money.isUseMoney(number)) {
                coinAmounts.remove((Integer) number);
            }
        }
    }

    private EnumMap<Coin, Integer> initCoins() {
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
        for (Coin coin : Coin.values()) {
            coins.put(coin, INITIAL_COIN_NUMBER);
        }
        return coins;
    }

    public EnumMap<Coin, Integer> getCoins() {
        return coins;
    }
}
