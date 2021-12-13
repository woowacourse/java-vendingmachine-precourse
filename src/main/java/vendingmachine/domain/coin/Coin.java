package vendingmachine.domain.coin;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import vendingmachine.validator.AmountValidator;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static int getSmallestCoinAmount() {
		List<Integer> allCoinAmount = getAllCoinAmount();
		return allCoinAmount.get(allCoinAmount.size() - 1);
	}

	public static int getSecondBiggestCoinAmount() {
		List<Integer> allCoinAmount = getAllCoinAmount();
		return allCoinAmount.get(1);
	}

	private static List<Integer> getAllCoinAmount() {
		return Arrays.stream(Coin.values())
			.map(coin -> coin.amount)
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());
	}

	public static Map<Integer, Integer> getCoinCounter(String amount) {
		AmountValidator.checkVendingMachineAmount(amount);
		Map<Integer, Integer> coinCounter = new LinkedHashMap<>();
		initializeCoinCounter(coinCounter);
		setCoinCounter(coinCounter, Integer.parseInt(amount));
		return coinCounter;
	}

	private static void initializeCoinCounter(Map<Integer, Integer> coinCounter) {
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		allCoinAmount.forEach(coinAmount -> coinCounter.put(coinAmount, DEFAULT_NUMBER));
	}

	private static void setCoinCounter(Map<Integer, Integer> coinCounter, int amount) {
		int randomCoinAmount;
		while (amount > 0) {
			randomCoinAmount = pickRandomCoinAmount(amount);
			coinCounter.put(randomCoinAmount, coinCounter.get(randomCoinAmount) + 1);
			amount -= randomCoinAmount;
		}
	}

	private static int pickRandomCoinAmount(int amount) {
		int randomCoinAmount;
		List<Integer> allCoinAmount = Coin.getAllCoinAmount();
		do {
			randomCoinAmount = pickNumberInList(allCoinAmount);
		} while (amount < randomCoinAmount);
		return randomCoinAmount;
	}
}
