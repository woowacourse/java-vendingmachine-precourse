package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private final Map<Coin, Integer> coinMap = new LinkedHashMap<>();
	private final List<Item> itemList = new ArrayList<>();

	private VendingMachine() {
	}

	public static VendingMachine create() {
		return new VendingMachine();
	}

	public Map<Coin, Integer> decideCoinRandomly(Coin[] coins, int balance) {
		for (int i = 0; i < coins.length - 1; i++) {
			List<Integer> possibleQuantity = Coin.getPossibleQuantity(coins[i], balance);
			coinMap.put(coins[i], Randoms.pickNumberInList(possibleQuantity));
			balance = Coin.calculateResidue(coins[i], balance, coinMap.get(coins[i]));
		}

		coinMap.put(coins[coins.length - 1], Coin.getMaxQuantity(coins[coins.length - 1], balance));
		return coinMap;
	}
}
