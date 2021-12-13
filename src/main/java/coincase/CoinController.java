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

	private int getSpecificCoinRandomNumInMoneyRange(Coin specificCoin, int remainMoney) {
		List<Integer> possibleCandidate = new ArrayList<>();
		for (int i = 0; i <= (remainMoney / specificCoin.getAmount()); ++i) {
			possibleCandidate.add(i);
		}
		return camp.nextstep.edu.missionutils.Randoms.pickNumberInList(possibleCandidate);
	}

	private int changeSomeMoneyToRandomCombinationCoin(int remainMoney) {
		for (Coin specificCoin : Coin.values()) {
			int randomNum = getSpecificCoinRandomNumInMoneyRange(specificCoin, remainMoney);
			numberOfCoins.put(specificCoin, numberOfCoins.get(specificCoin) + randomNum);
			remainMoney -= (specificCoin.getAmount() * randomNum);
		}
		return remainMoney;
	}

	public Map<Coin, Integer> makeRandomCombinationCoin(int money) {
		int remainMoney = money;
		while (remainMoney != 0) {
			remainMoney = changeSomeMoneyToRandomCombinationCoin(remainMoney);
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
