package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	static final String HYPHEN = " - ";
	static final String COUNTING_UNIT_AND_ENTER = "개\n";

	private final Map<Coin, Integer> coins = new TreeMap<>();
	private final int totalMoney;

	public Coins(int totalMoney) {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
		this.totalMoney = totalMoney;
		makeRandomNumberOfCoins();
	}

	private void makeRandomNumberOfCoins() {
		int tempMoneyInMachine = totalMoney;
		while (tempMoneyInMachine != 0) {
			int randomAmount = getRandomAmount(tempMoneyInMachine);
			tempMoneyInMachine -= randomAmount;
			if (randomAmount != 0) {
				increaseCoin(randomAmount);
			}
		}
	}

	private int getRandomAmount(int tempMoneyInMachine) {
		int randomAmount = Randoms.pickNumberInList(Coin.amountList());
		if (randomAmount <= tempMoneyInMachine) {
			return randomAmount;
		}
		return 0;
	}

	private void increaseCoin(int amount) {
		Coin coin = Coin.getByAmount(amount);
		coins.put(coin, coins.get(coin) + 1);
	}

	public Map<Coin, Integer> getCoinsMap() {
		return coins;
	}

	public Map<Coin, Integer> calculateChange(int money) {
		Map<Coin, Integer> change = new TreeMap<>();
		for (int amount : Coin.amountList()) {
			Coin coin = Coin.getByAmount(amount);
			int count = Math.min(money / amount, coins.get(coin));
			change.put(coin, count);
			money -= amount * count;
		}
		return change;
	}

	public boolean isGreaterThanTotalMoney(int money) {
		return money > totalMoney;
	}

	@Override
	public String toString() {
		StringBuilder retString = new StringBuilder();
		coins.forEach((key, value) ->
			retString.append(key + HYPHEN + value + COUNTING_UNIT_AND_ENTER));
		return retString.toString();
	}
}