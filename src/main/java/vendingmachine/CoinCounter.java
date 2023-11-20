package vendingmachine;

import java.util.EnumMap;
import java.util.Map;

public class CoinCounter {

    private final Map<Coin, Integer> coinCounterMap = new EnumMap<>(Coin.class);

    public Map<Coin, Integer> getCounter(Amount amount) {
        int targetAmount = amount.getMoney();
        for (Coin coin : Coin.values()){
            int coinNumbers = targetAmount / coin.getAmount();
            coinCounterMap.put(coin, coinNumbers);
            targetAmount %= coin.getAmount();
        }
        return coinCounterMap;
    }
}
