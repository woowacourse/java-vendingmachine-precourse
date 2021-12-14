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
	private final Map<Coin, Integer> coinCounter;

	public CoinCounter() {
		this.coinCounter = new LinkedHashMap<>();
	}

	public void setVendingMachineCoinCounter(int amount) {
		AmountValidator.checkVendingMachineAmount(amount);
		initializeCoinCounter(coinCounter);
		setCoinCounter(coinCounter, amount);
	}

	private void initializeCoinCounter(Map<Coin, Integer> coinCounter) {
		List<Coin> allCoin = Coin.getAllCoin();
		allCoin.forEach(coin -> coinCounter.put(coin, DEFAULT_NUMBER));
	}

	private void setCoinCounter(Map<Coin, Integer> coinCounter, int amount) {
		Coin randomCoin;
		while (amount > 0) {
			randomCoin = RandomCoinGenerator.pickRandomCoinAmount(amount);
			coinCounter.put(randomCoin, coinCounter.get(randomCoin) + 1);
			amount -= randomCoin.getAmount();
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		coinCounter.forEach(
			(coin, count) -> result.append(coin + WON + count + AMOUNT_UNIT + "\n")
		);
		return result.toString();
	}

	public CoinCounter getChangeCoinCounter(User user) {
		CoinCounter change = new CoinCounter();
		setChangeCoinCounter(change.coinCounter, user.getAmount());
		return change;
	}

	private void setChangeCoinCounter(Map<Coin, Integer> changeCoinCounter, int userAmount) {
		for (Coin coin : coinCounter.keySet()) {
			int count = coinCounter.get(coin);
			int maximumCountOfChangeCoin = Math.min(userAmount / coin.getAmount(), count);
			putCoinAmount(changeCoinCounter, coin, maximumCountOfChangeCoin);
			userAmount -= coin.getAmount() * maximumCountOfChangeCoin;
		}
	}

	private void putCoinAmount(Map<Coin, Integer> changeCoinCounter, Coin coin, int maximumCountOfChangeCoin) {
		if (maximumCountOfChangeCoin > 0) {
			changeCoinCounter.put(coin, maximumCountOfChangeCoin);
			coinCounter.put(coin, coinCounter.get(coin) - maximumCountOfChangeCoin);
		}
	}
}
