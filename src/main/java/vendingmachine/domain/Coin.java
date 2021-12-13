package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
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

	public static void add(int inputMachineMoney) {
		Coin[] coins = Coin.values();
		for (Coin coin : coins) {
			int quotient = inputMachineMoney / coin.amount;
			inputMachineMoney %= coin.amount;
			coin.count = quotient;
		}
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

	@Override
	public String toString() {
		return "Coin{" +
			"amount=" + amount +
			", count=" + count +
			'}';
	}
}
