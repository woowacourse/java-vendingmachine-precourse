package vendingmachine.coin;

import java.util.Map;

import vendingmachine.Amount;

public interface CoinGenerator {
	Map<Coin, Integer> generate(Amount amount);
}
