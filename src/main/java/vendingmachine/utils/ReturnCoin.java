package vendingmachine.utils;

import java.util.EnumMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class ReturnCoin {

	public static Map<Coin, Integer> getReturnCoin(Map<Coin, Integer> holdingCoin, int returnAmount) {
		Map<Coin, Integer> returnCoin = new EnumMap<>(Coin.class);

		for (Map.Entry<Coin, Integer> e : holdingCoin.entrySet()) {
			int useCoin = Math.min(returnAmount / e.getKey().getAmount(), e.getValue());

			if (useCoin == 0) {
				continue;
			}

			returnAmount -= useCoin * e.getKey().getAmount();
			returnCoin.put(e.getKey(), useCoin);
		}
		return returnCoin;
	}
}
