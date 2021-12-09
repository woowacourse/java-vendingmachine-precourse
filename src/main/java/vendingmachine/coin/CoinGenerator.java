package vendingmachine.coin;

import java.util.Map;

public interface CoinGenerator {
	Map<Coin, Integer> generate(int amount);
}
