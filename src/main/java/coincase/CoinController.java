package coincase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.Coin;

public class CoinController {
	private Map<Coin, Integer> numberOfCoins;
	private CoinRuleChecker coinRuleChecker;

	public CoinController() {
		initNumberOfCoins();
		coinRuleChecker = new CoinRuleChecker();
	}

	private void initNumberOfCoins() {
		numberOfCoins = new HashMap<>();
		numberOfCoins.put(Coin.COIN_500, 0);
		numberOfCoins.put(Coin.COIN_100, 0);
		numberOfCoins.put(Coin.COIN_50, 0);
		numberOfCoins.put(Coin.COIN_10, 0);
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
				numberOfCoins.put(specificCoin, numberOfCoins.get(specificCoin) + 1);
			}
		}
	}

	public Map<Coin, Integer> makeRandomCombinationCoin(int money) {
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
		coinNum = Math.min(coinNum, numberOfCoins.get(specificCoin));
		numberOfCoins.put(specificCoin, numberOfCoins.get(specificCoin) - coinNum);
		return coinNum;
	}

	public Map<Coin, Integer> getChange(int remainMoney) {
		Map<Coin, Integer> change = new HashMap<>();
		for (Coin specificCoin : Coin.values()) {
			int number = changeMoneyToCoinAsManyAsPossible(specificCoin, remainMoney);
			if (number != 0) {
				change.put(specificCoin, number);
				remainMoney -= (specificCoin.getAmount() * number);
			}
		}
		return change;
	}
}
