package vendingmachine.domain.coin;

import static vendingmachine.constant.OutputMessage.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.user.User;
import vendingmachine.util.RandomCoinGenerator;
import vendingmachine.validator.AmountValidator;

public class CoinCounter {
	private final Map<Integer, Integer> coinCounter;

	public CoinCounter() {
		this.coinCounter = new LinkedHashMap<>();
	}

	public void setVendingMachineCoinCounter(int amount) {
		AmountValidator.checkVendingMachineAmount(amount);
		initializeCoinCounter(coinCounter);
		setCoinCounter(coinCounter, amount);
	}

	private void initializeCoinCounter(Map<Integer, Integer> coinCounter) {
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		allCoinAmount.forEach(coinAmount -> coinCounter.put(coinAmount, DEFAULT_NUMBER));
	}

	private void setCoinCounter(Map<Integer, Integer> coinCounter, int amount) {
		int randomCoinAmount;
		while (amount > 0) {
			randomCoinAmount = RandomCoinGenerator.pickRandomCoinAmount(amount);
			coinCounter.put(randomCoinAmount, coinCounter.get(randomCoinAmount) + 1);
			amount -= randomCoinAmount;
		}
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
			int maximumNumberOfCoin = Math.min(userAmount / coinAmount, numberOfCoin);
			putCoinAmount(changeCoinCounter, coinAmount, maximumNumberOfCoin);
			userAmount -= coinAmount * maximumNumberOfCoin;
		}
	}

	private void putCoinAmount(Map<Integer, Integer> changeCoinCounter, int coinAmount, int maximumNumberOfCoin) {
		if (maximumNumberOfCoin > 0) {
			changeCoinCounter.put(coinAmount, maximumNumberOfCoin);
			coinCounter.put(coinAmount, coinCounter.get(coinAmount) - maximumNumberOfCoin);
		}
	}
}
