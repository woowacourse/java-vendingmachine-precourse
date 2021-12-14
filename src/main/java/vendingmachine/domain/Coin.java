package vendingmachine.domain;

import static vendingmachine.constant.SystemMessage.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {

	COIN_500(500, 0),
	COIN_100(100, 0),
	COIN_50(50, 0),
	COIN_10(10, 0);

	private final int amount;
	private int count;

	Coin(final int amount, int count) {
		this.amount = amount;
		this.count = count;
	}

	public static void clear() {
		for (Coin coin : Coin.values()) {
			coin.count = 0;
		}
	}

	private static Coin of(Integer coinAmount) {
		return getCoinStream()
				.filter(coin -> coin.amount == coinAmount)
				.findAny()
				.get();
	}

	public static void add(int inputMachineMoney) {
		Coin[] coins = Coin.values();
		for (Coin coin : coins) {
			int quotient = inputMachineMoney / coin.amount;
			inputMachineMoney %= coin.amount;
			coin.count = quotient;
		}
	}

	public static void generateRandomCount(int machineMoney) {
		List<Integer> coinAmountList = getCoinAmountList();
		while (machineMoney != 0) {
			Coin randomCoin = getRandomCoin(coinAmountList);
			if (machineMoney - randomCoin.amount < 0) {
				continue;
			}
			randomCoin.count++;
			machineMoney -= randomCoin.amount;
		}
	}

	private static Coin getRandomCoin(List<Integer> coinAmountList) {
		int randomCoinAmount = Randoms.pickNumberInList(coinAmountList);
		return findCoinByAmount(randomCoinAmount);
	}

	private static Coin findCoinByAmount(int randomCoinAmount) {
		return getCoinStream()
			.filter(coin -> coin.amount == randomCoinAmount)
			.findAny()
			.get();
	}

	private static List<Integer> getCoinAmountList() {
		return getCoinStream()
			.map(coin -> coin.amount)
			.collect(Collectors.toList());
	}

	public static List<Coin> get() {
		return getCoinStream()
			.collect(Collectors.toList());
	}

	public static int getTotal() {
		return getCoinStream()
			.mapToInt(Coin::getSubTotal)
			.sum();
	}

	private static Stream<Coin> getCoinStream() {
		return Arrays.stream(Coin.values());
	}

	private static int getSubTotal(Coin coin) {
		return coin.amount * coin.count;
	}

	public static Map<Integer, Integer> getChanges(int remainingMoney) {
		if (remainingMoney >= Coin.getTotal()) {
			return convertCoinToMap();
		}
		Map<Integer, Integer> changes = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			int changesCount = getChangesCount(coin, remainingMoney);
			changes.put(coin.amount, changesCount);
			remainingMoney -= (coin.amount * changesCount);
		}
		return changes;
	}

	public static int getChangesCount(Coin coin, int remainingMoney) {
		int quotient = remainingMoney / coin.amount;
		return Math.min(quotient, coin.count);
	}

	private static Map<Integer, Integer> convertCoinToMap() {
		List<Coin> coins = Coin.get();
		Map<Integer, Integer> coinMap = new LinkedHashMap<>();
		for (Coin coin : coins) {
			coinMap.put(coin.amount, coin.count);
		}
		return coinMap;
	}

	public static void minusChangesFromMachineMoney(Map<Integer, Integer> changes) {
		for (Map.Entry<Integer, Integer> entry : changes.entrySet()) {
			Integer coinAmount = entry.getKey();
			Integer coinCount = entry.getValue();
			Coin coin = Coin.of(coinAmount);
			coin.count -= coinCount;
		}
	}

	public void selfDescription() {
		System.out.printf(SELF_DESCRIPTION_FORMAT, amount, count);
	}

	@Override
	public String toString() {
		return "Coin{" +
			"amount=" + amount +
			", count=" + count +
			'}';
	}
}
