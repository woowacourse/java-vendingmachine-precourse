package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinController {
	private Map<Coin, Integer> numberOfCoins;

	CoinController() {
		initNumberOfCoins();
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

	protected Map<Coin, Integer> makeRandomCombinationCoin(int money) {
		int remainMoney = money;
		while (remainMoney != 0) {
			remainMoney = changeSomeMoneyToRandomCombinationCoin(remainMoney);
		}
		return numberOfCoins;
	}
}
