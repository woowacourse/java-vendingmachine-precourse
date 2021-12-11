package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	public static final int[] COIN_ARRAY = {500, 100, 50, 10};
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getPossibleQuantity(Integer amount, int balance) {
		List<Integer> list = new ArrayList<>();
		for (int quantity = 0; quantity <= getMaxQuantity(amount, balance); quantity++) {
			list.add(quantity);
		}
		return list;
	}

	public static int calculateResidue(Integer amount, int balance, int quantity) {
		return balance - amount * quantity;
	}

	public static int getMaxQuantity(Integer amount, int balance) {
		return balance / amount;
	}

	public static List<Integer> getCoinList() {
		return Arrays.stream(COIN_ARRAY)
			.boxed()
			.collect(Collectors.toList());
	}

	public static Map<Integer, Integer> decideCoinRandomly(Map<Integer, Integer> coinMap, int balance) {
		List<Integer> coinList = getCoinList();
		for (Integer coin : coinList) {
			List<Integer> possibleQuantity = Coin.getPossibleQuantity(coin, balance);
			coinMap.put(coin, Randoms.pickNumberInList(possibleQuantity));
			balance = Coin.calculateResidue(coin, balance, coinMap.get(coin));
		}

		Integer lastCoin = coinList.get(coinList.size() - 1);
		coinMap.put(lastCoin, Coin.getMaxQuantity(lastCoin, balance));
		return coinMap;
	}
}
