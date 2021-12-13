package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private final Map<Coin, Integer> coins = new TreeMap<>();
	private final int totalMoney;

	public Coins(int totalMoney) {
		for (Coin coin : Coin.values()){
			coins.put(coin, 0);
		}
		this.totalMoney = totalMoney;
	}

	public void initRandomNumberOfCoins() {
		int tempMoneyInMachine = totalMoney;
		while (tempMoneyInMachine != 0){
			int randomAmount = getRandomAmount(tempMoneyInMachine);
			tempMoneyInMachine -= randomAmount;
			increaseCoin(randomAmount);
		}
	}

	public Coins calculateChange(int money) {
		Coins change = new Coins(totalMoney);
		for(int amount : Coin.amountList()){
			Coin coin = Coin.getByAmount(amount);
			int count = Math.min(money/amount, coins.get(coin));
			change.putCoin(coin, count);
			money -= amount * count;
		}
		return change;
	}

	public boolean isGreaterThanTotalMoney(int money) {
		return money > totalMoney;
	}

	private int getRandomAmount(int tempMoneyInMachine) {
		int randomAmount = Randoms.pickNumberInList(Coin.amountList());
		if (randomAmount <= tempMoneyInMachine) {
			return randomAmount;
		}
		return 0;
	}

	private void putCoin(Coin coin, int count) {
		coins.put(coin, count);
	}

	private void increaseCoin(int amount) {
		Coin coin = Coin.getByAmount(amount);
		coins.put(coin, coins.get(coin) + 1);
	}

	@Override
	public String toString() {
		StringBuilder retString = new StringBuilder();
		coins.forEach((key, value) -> retString.append(key + " - " + value + "개\n"));
		return retString.toString();
	}
}