package vendingmachine.domain;

import java.util.Map;

public interface CoinGenerator {
	Map<Coin, Quantity> generate(Money money);
}
