package vendingmachine.coin.generator;

import java.util.Map;
import vendingmachine.coin.Coin;

public interface CoinGenerator {
    Map<Coin, Integer> getCoins(int totalMoney);
}
