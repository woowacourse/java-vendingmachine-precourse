package vendingmachine.coin;

import java.util.Map;

import vendingmachine.Money;

public interface CoinGenerator {
	Coins generate(Money money);
}
