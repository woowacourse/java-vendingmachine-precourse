package vendingmachine.domain.coin;

import static vendingmachine.utils.ArithmeticValidator.*;
import static vendingmachine.utils.Formatter.*;
import static vendingmachine.utils.StringValidator.*;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

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

		int leftAmount = totalAmount;

		while (leftAmount != 0) {
			Coin coin = RandomCoinSelector.selectCoinCheaperThanOrEqualToValue(leftAmount);
			coinMap.put(coin, coinMap.get(coin) + 1);

			leftAmount -= coin.getAmount();
		}

		return coinMap;
	}

	private static Map<Coin, Integer> initCoinMap() {
		Map<Coin, Integer> coinMap = new TreeMap<>(new CoinMapComparator());
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, 0);
		}
		return coinMap;
	}

	public int getTotalAmount() {
		return coinMap.entrySet().stream()
			.map(entry -> entry.getKey().getAmount() * entry.getValue())
			.reduce(0, Integer::sum);
	}

	public boolean hasCoinCheaperThanOrEqualToValue(int value) {
		return coinMap.entrySet().stream()
			.anyMatch(entry -> entry.getValue() > 0 && entry.getKey().getAmount() <= value);
	}

	public Coin popMaxPriceCoinCheaperThanOrEqualToValue(int value) {
		Coin coin = peekMaxPriceCoinCheaperThanOrEqualToValue(value);
		coinMap.put(coin, coinMap.get(coin) - 1);
		return coin;
	}

	public Coin peekMaxPriceCoinCheaperThanOrEqualToValue(int value) {
		return coinMap.entrySet().stream()
			.filter(entry -> entry.getValue() > 0)
			.filter(entry -> entry.getKey().getAmount() <= value)
			.map(entry -> entry.getKey())
			.max(Comparator.comparing(Coin::getAmount))
			.orElseThrow(() -> new NoSuchElementException("[ERROR] 해당 값 이하의 코인이 존재하지 않습니다."));
	}

	public boolean isEmpty() {
		return coinMap.values().stream()
			.allMatch(value -> value == 0);
	}

	public Map<Coin, Integer> getCoins() {
		return coinMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Coin coin : coinMap.keySet()) {
			sb.append(
				formatToKoreanCurrencyUnit(coin.getAmount()))
			;
			sb.append(" - ");
			sb.append(
				formatToKoreanItemCountUnit(coinMap.get(coin))
			);
			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}
}
