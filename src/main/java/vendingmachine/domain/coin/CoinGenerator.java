package vendingmachine.domain.coin;

import vendingmachine.domain.money.Money;

public interface CoinGenerator {
	Coins generate(Money money);
}
