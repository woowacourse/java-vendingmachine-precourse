package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.NumberChecker;

public class HoldingSum {

	private Map<String, Integer> coinMap;

	public int getCoinCount(String coinName) {
		return coinMap.getOrDefault(coinName, 0);
	}

	public void set(String input) {
		checkInput(input);
		coinMap = generateCoinsRandomly(input);
	}

	private void checkInput(String input) {
		NumberChecker numberChecker = new NumberChecker();
		numberChecker.isPositiveInteger(input);
		numberChecker.isDivisibleNumber(input, Coin.minAmount());
	}

	private Map<String, Integer> generateCoinsRandomly(String input) {
		Map<String, Integer> coinMap = new HashMap<>();
		int restMoney = Integer.valueOf(input);

		while (restMoney != 0) {
			int randomCoinAmount = Randoms.pickNumberInList(Coin.getAmountList());

			if (restMoney >= randomCoinAmount) {
				restMoney -= randomCoinAmount;
				String coinName = Coin.getName(randomCoinAmount);
				coinMap.put(coinName, coinMap.getOrDefault(coinName, 0) + 1);
			}
		}
		return coinMap;
	}
}
