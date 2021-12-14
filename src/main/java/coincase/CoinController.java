package coincase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinController {
	private Map<Integer, Integer> numberOfCoins;

	public CoinController() {
		initNumberOfCoins();
	}

	private void initNumberOfCoins() {
		numberOfCoins = new HashMap<>();
		numberOfCoins.put(Coin.COIN_500.getAmount(), 0);
		numberOfCoins.put(Coin.COIN_100.getAmount(), 0);
		numberOfCoins.put(Coin.COIN_50.getAmount(), 0);
		numberOfCoins.put(Coin.COIN_10.getAmount(), 0);
	}

	private List<Integer> getPossibleCoins() {
		List<Integer> possibleCoins = new ArrayList<>();
		for (Coin possibleCoin : Coin.values()) {
			possibleCoins.add(possibleCoin.getAmount());
		}
		return possibleCoins;
	}

	private void addCoin(int coinAmount) {
		for (Coin specificCoin : Coin.values()) {
			if (specificCoin.getAmount() == coinAmount) {
				int key = specificCoin.getAmount();
				numberOfCoins.put(key, numberOfCoins.get(key) + 1);
			}
		}
	}

	public Map<Integer, Integer> makeRandomCombinationCoin(int money) {
		List<Integer> possibleCoins = getPossibleCoins();
		while (money != 0) {
			int coinAmount = camp.nextstep.edu.missionutils.Randoms.pickNumberInList(possibleCoins);
			if (coinAmount <= money) {
				money -= coinAmount;
				addCoin(coinAmount);
			}
		}
		return numberOfCoins;
	}

	private int changeMoneyToCoinAsManyAsPossible(Coin specificCoin, int money) {
		int coinNum = money / specificCoin.getAmount();
		int key = specificCoin.getAmount();
		coinNum = Math.min(coinNum, numberOfCoins.get(key));
		numberOfCoins.put(key, numberOfCoins.get(key) - coinNum);
		return coinNum;
	}

	public Map<Integer, Integer> getChange(int remainMoney) {
		Map<Integer, Integer> change = new HashMap<>();
		for (Coin specificCoin : Coin.values()) {
			int number = changeMoneyToCoinAsManyAsPossible(specificCoin, remainMoney);
			if (number != 0) {
				change.put(specificCoin.getAmount(), number);
				remainMoney -= (specificCoin.getAmount() * number);
			}
		}
		return change;
	}
}
