package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

public interface CoinService {
	Map<Coin, Integer> generateCoinMap(Money money);
}
