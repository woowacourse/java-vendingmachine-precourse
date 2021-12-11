package vendingmachine.domain.coin;

import static vendingmachine.utils.ArithmeticValidator.*;
import static vendingmachine.utils.StringValidator.*;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.utils.RandomCoinSelector;

public class Coins {
	private static final String ERROR_NOT_NUMBER = "[ERROR] 보유 금액은 정수입니다.";
	private static final String ERROR_LT_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원 이상입니다.";
	private static final String ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN = "[ERROR] 보유 금액은 10원의 배수입니다.";

	private final Map<Coin, Integer> coinMap;

	public Coins(Map<Coin, Integer> coinMap) {
		this.coinMap = coinMap;
	}

	public static Coins generateCoinsRandomlyFromTotalAmount(String totalAmountInput) {
		validateTotalAmountInput(totalAmountInput);
		int totalAmount = Integer.parseInt(totalAmountInput);
		return new Coins(generateCoinMapAccordingToRule(totalAmount));
	}

	private static void validateTotalAmountInput(String totalAmountInput) {
		validateNumber(totalAmountInput, ERROR_NOT_NUMBER);
		int totalAmount = Integer.parseInt(totalAmountInput);

		validateGreaterThanOrEqualToMinPriceCoin(totalAmount);
		validateDividingByMinPriceCoin(totalAmount, ERROR_NOT_DIVISIBLE_BY_MIN_PRICE_COIN);
	}

	private static void validateGreaterThanOrEqualToMinPriceCoin(int leftMoney) {
		if (leftMoney < Coin.getMinPriceCoin().getAmount()) {
			throw new IllegalArgumentException(ERROR_LT_MIN_PRICE_COIN);
		}
	}

	private static Map<Coin, Integer> generateCoinMapAccordingToRule(int totalAmount) {
		Map<Coin, Integer> coinMap = initCoinMap();

		while (totalAmount != 0) {
			Coin coin = RandomCoinSelector.selectCoinCheaperThanOrEqualToValue(totalAmount);
			coinMap.put(coin, coinMap.get(coin) + 1);

			totalAmount -= coin.getAmount();
		}

		return coinMap;
	}

	private static Map<Coin, Integer> initCoinMap() {
		Map<Coin, Integer> coinMap = new HashMap<>();
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, 0);
		}
		return coinMap;
	}

	public Map<Coin, Integer> getCoins() {
		return coinMap;
	}
}
