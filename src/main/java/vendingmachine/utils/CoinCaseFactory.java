package vendingmachine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinCase;

public class CoinCaseFactory {

	public static int currentAmount;

	private CoinCaseFactory() {
	}

	public static List<CoinCase> makeCoinsCase(int totalAmount) {
		currentAmount = totalAmount;
		List<CoinCase> coinsCase = new ArrayList<>();
		List<Coin> coinTypes = Arrays.stream(Coin.values()).collect(Collectors.toList());
		for (Coin coin : coinTypes) {
			coinsCase.add(makeCoinCase(coin));
		}
		return coinsCase;
	}

	public static CoinCase makeCoinCase(Coin coin) {
		CoinCase coinCase = new CoinCase(coin, currentAmount);
		currentAmount = coinCase.getCurrentAmount();
		return coinCase;
	}
}
