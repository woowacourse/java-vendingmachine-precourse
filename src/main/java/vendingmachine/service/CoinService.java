package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.Quantity;

public interface CoinService {
	Map<Coin, Quantity> generateCoinMap(Money money);
}
