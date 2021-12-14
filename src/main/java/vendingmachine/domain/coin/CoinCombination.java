package vendingmachine.domain.coin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static vendingmachine.constant.OutputViewMessage.COUNT_MESSAGE;
import static vendingmachine.constant.OutputViewMessage.HYPHEN_MINUS;

public class CoinCombination {
    private final Map<Coin, Integer> coinCombination;

    public CoinCombination() {
        coinCombination = new LinkedHashMap<>();
    }

    public void put(Coin coin, Integer count) {
        coinCombination.put(coin, count);
    }

    public Map<Coin, Integer> getCoinCombination() {
        return coinCombination;
    }
}
