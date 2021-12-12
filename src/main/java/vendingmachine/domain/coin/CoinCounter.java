package vendingmachine.domain.coin;

import static vendingmachine.constant.OutputMessage.*;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.user.User;

public class CoinCounter {
	private Map<Integer, Integer> coinCounter;

	private CoinCounter() {
		coinCounter = new LinkedHashMap<>();
	}

	public CoinCounter(Map<Integer, Integer> coinCounter) {
		this.coinCounter = coinCounter;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		coinCounter.forEach(
			(coinAmount, numberOfCoins) -> result.append(coinAmount + WON + numberOfCoins + AMOUNT_UNIT + "\n")
		);
		return result.toString();
	}

	public CoinCounter getChangeCoinCounter(User user) {
		CoinCounter change = new CoinCounter();
		setChangeCoinCounter(change.coinCounter, user.getAmount());
		return change;
	}

	private void setChangeCoinCounter(Map<Integer, Integer> changeCoinCounter, int userAmount) {
		for (int coinAmount : coinCounter.keySet()) {
			int numberOfCoin = coinCounter.get(coinAmount);
			int maximumNumberOfCoin = getMaximumNumberOfCoin(userAmount, coinAmount, numberOfCoin);
			putCoinAmount(changeCoinCounter, coinAmount, maximumNumberOfCoin);
			userAmount -= coinAmount * maximumNumberOfCoin;
		}
	}

	private int getMaximumNumberOfCoin(int userAmount, int coinAmount, int numberOfCoin) {
		int maximumNumberOfCoin = userAmount / coinAmount;
		return Math.min(numberOfCoin, maximumNumberOfCoin);
	}

	private void putCoinAmount(Map<Integer, Integer> changeCoinCounter, int coinAmount, int maximumNumberOfCoin) {
		if (maximumNumberOfCoin > 0) {
			changeCoinCounter.put(coinAmount, maximumNumberOfCoin);
		}
	}
}
