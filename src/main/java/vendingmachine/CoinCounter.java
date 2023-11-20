package vendingmachine;

import java.util.EnumMap;
import java.util.Map;
public class CoinCounter {

    private final Map<Coin, Integer> coinCounterMap = new EnumMap<>(Coin.class);
    private final Map<Coin, Integer> remainCounterMap = new EnumMap<>(Coin.class);
    public Map<Coin, Integer> getCounter(MachineAmount amount) {
        int vendingMoney = amount.getMoney();
        for (Coin coin : Coin.values()){
            int coinNumbers = vendingMoney / coin.getAmount();
            coinCounterMap.put(coin, coinNumbers);
            vendingMoney %= coin.getAmount();
        }
        return coinCounterMap;
    }

    public Map<Coin, Integer> getRemainCounter(MachineAmount amount, int remainder) {
        int vendingMoney = amount.getMoney();
        if (remainder >= vendingMoney) {
            for (Coin remainderCoin : Coin.values()) {
                int remainCoinNumbers = vendingMoney / remainderCoin.getAmount();
                remainCounterMap.put(remainderCoin, remainCoinNumbers);
                vendingMoney %= remainderCoin.getAmount();
            }
        }
        return remainCounterMap;
    }
}
