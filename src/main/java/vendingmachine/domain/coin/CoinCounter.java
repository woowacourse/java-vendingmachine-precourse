package vendingmachine.domain.coin;

import static vendingmachine.constant.OutputMessage.*;

import java.util.Map;

import vendingmachine.domain.user.User;

public class CoinCounter {
	private final Map<Integer, Integer> coinCounter;

	public CoinCounter(Map<Integer, Integer> coinCounter) {
		this.coinCounter = coinCounter;
	}

	public void makeChangeCoinCounter(User user) {
		int userAmount = user.getAmount();
		for (int coinAmount : coinCounter.keySet()) {
			int count = coinCounter.get(coinAmount);
			int maximumCount = Math.min(userAmount / coinAmount, count);
			coinCounter.put(coinAmount, maximumCount);
			userAmount -= coinAmount * maximumCount;
		}
	}

	public String getVendingMachineStatus() {
		StringBuilder result = new StringBuilder();
		coinCounter.forEach(
			(coinAmount, numberOfCoins) -> result.append(coinAmount + WON + numberOfCoins + AMOUNT_UNIT + "\n")
		);
		return result.toString();
	}

	public String getChangeStatus() {
		StringBuilder result = new StringBuilder();
		coinCounter.forEach(
			(coinAmount, numberOfCoins) -> {
				if (numberOfCoins > 0) {
					result.append(coinAmount + WON + numberOfCoins + AMOUNT_UNIT + "\n");
				}
			}
		);
		return result.toString();
	}
}
