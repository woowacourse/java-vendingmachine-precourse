package vendingmachine.utils;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class RandomCoinSelector {

	public static Coin selectCoinInAllCoins() {
		List<Coin> allCoinList = getAllCoinList();
		int randomAmount = Randoms.pickNumberInList(getAmountList(allCoinList));
		return Coin.valueOf(randomAmount);
	}

	public static Coin selectCoinCheaperThanOrEqualToValue(int value) {
		List<Coin> coinListCheaperThanValue = getCoinListCheaperThanOrEqualToValue(value);
		int randomAmout = Randoms.pickNumberInList(getAmountList(coinListCheaperThanValue));
		return Coin.valueOf(randomAmout);
	}

	private static List<Coin> getAllCoinList() {
		return Arrays.asList(Coin.values());
	}

	private static List<Coin> getCoinListCheaperThanOrEqualToValue(int value) {
		List<Coin> allCoins = getAllCoinList();
		return allCoins.stream()
			.filter(coin -> coin.getAmount() <= value)
			.collect(toList());
	}

	private static List<Integer> getAmountList(List<Coin> coins) {
		return coins.stream()
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}
}
