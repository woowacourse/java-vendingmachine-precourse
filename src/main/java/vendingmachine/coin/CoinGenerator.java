package vendingmachine.coin;

import vendingmachine.Money;

public interface CoinGenerator {
	Coins generate(Money money);
}
