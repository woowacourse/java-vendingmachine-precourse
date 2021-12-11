package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class VendingMachine {
	private int changeAmount;
	private HashMap<Integer, Integer> coins = new HashMap<>();

	public VendingMachine(int changeAmount) {
		this.changeAmount = changeAmount;
	}

	public void generateCoins() {
		int sumAmount = 0;
		do {
			int coin = Randoms.pickNumberInList(filterCoins(sumAmount));
			sumAmount += coin;
			if (coins.containsKey(coin)) {
				coins.put(coin, coins.get(coin) + 1);
			}
			coins.putIfAbsent(coin, 1);
		} while (sumAmount < changeAmount);
	}

	private List<Integer> filterCoins(int sumAmount) {
		return Stream.of(Coin.values())
			.map(Coin::getAmount)
			.filter(amount -> amount <= (changeAmount - sumAmount))
			.collect(Collectors.toList());
	}
}
