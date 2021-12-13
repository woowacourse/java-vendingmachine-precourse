package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private static final HashMap<Integer, Integer> coins = new HashMap<>();
	private int changeAmount;

	public void inputChangAmount(int changeAmount) {
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

	public String coinsToString() {
		StringBuilder result = new StringBuilder();
		Coin.getAmountList()
			.forEach(amount -> result.append(
				String.format("%d원 - %d개\n", amount, coins.getOrDefault(amount, 0))
			));
		return result.toString();
	}

	public HashMap<Integer, Integer> selectCoinsToBeReturned(int userInputAmount) {
		List<Integer> changeList = Coin.getAmountList().stream()
			.filter(coins::containsKey)
			.collect(Collectors.toList());

		int greedyAmount = userInputAmount;
		HashMap<Integer, Integer> resultCoins = new HashMap<>();
		for (int c : changeList) {
			if (greedyAmount >= c) {
				int cnt = Math.min(greedyAmount / c, coins.get(c));
				resultCoins.put(c, resultCoins.getOrDefault(c, 0) + cnt);
				greedyAmount -= cnt * c;
			}
		}
		return resultCoins;
	}
}
