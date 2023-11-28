package vendingmachine.domain.coin.generator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import vendingmachine.domain.coin.Coin;

public interface CoinGenerator {
    List<Integer> coinAmounts = Arrays.stream(Coin.values())
            .map(Coin::getAmount)
            .toList();

    default EnumMap<Coin, Integer> generate(int money) {
        EnumMap<Coin, Integer> coins = initCoins();
        while (money > 0) {
            Coin coin = pickCoin();
            if(coin.getAmount() <= money){
                coins.put(coin, coins.get(coin) + 1);
                money -= coin.getAmount();
            }
        }
        return coins;
    }

    private static EnumMap<Coin, Integer> initCoins() {
        EnumMap<Coin, Integer> coins = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values())
                .forEach(coin -> coins.put(coin, 0));
        return coins;
    }

    Coin pickCoin();
}
