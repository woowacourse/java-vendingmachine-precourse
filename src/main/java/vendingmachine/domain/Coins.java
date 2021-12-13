package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private final Map<Coin, Integer> coins = new TreeMap<>();
	private int moneyInMachine;

	public Coins(int moneyInMachine) {
		for (Coin coin : Coin.values()){
			coins.put(coin, 0);
		}
		this.moneyInMachine = moneyInMachine;
		makeRandomNumberOfCoins();
	}

	private void makeRandomNumberOfCoins() {
		int tempMoneyInMachine = moneyInMachine;
		while (tempMoneyInMachine != 0){
			int randomAmount = getRandomAmount(tempMoneyInMachine);
			tempMoneyInMachine -= randomAmount;
			plusCoin(randomAmount);
		}
	}

	private int getRandomAmount(int tempMoneyInMachine) {
		int randomAmount = Randoms.pickNumberInList(Coin.amountList());
		if (randomAmount <= tempMoneyInMachine) {
			return randomAmount;
		}
		return 0;
	}

	private void plusCoin(int randomAmount) {
		Coin coin = Coin.getByAmount(randomAmount);
		coins.put(coin, coins.get(coin) + 1);
	}
}