package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class VendingMachine {
	private int changeAmount;
	private static HashMap<Integer, Integer> coins = new HashMap<>();

	public VendingMachine(int changeAmount) {
		this.changeAmount = changeAmount;
	}

	public void generateCoins() {
		int sumAmount = 0;
		do {
			int coin = Randoms.pickNumberInList(filterCoins(sumAmount));
			sumAmount += coin;
			coins.put(coin, coins.getOrDefault(coin, 0) + 1);
		} while (sumAmount < changeAmount);
	}

	private List<Integer> filterCoins(int sumAmount) {
		return Stream.of(Coin.values())
			.map(Coin::getAmount)
			.filter(amount -> amount <= (changeAmount - sumAmount))
			.collect(Collectors.toList());
	}

	public static String printCoins() {
		StringBuilder result = new StringBuilder();
		Stream.of(Coin.values())
			.map(Coin::getAmount)
			.forEach(amount -> result.append(
				String.format("%d원 - %d개\n", amount, coins.getOrDefault(amount, 0))
			));
		return result.toString();
	}
}
