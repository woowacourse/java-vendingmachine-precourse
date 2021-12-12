package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinCase;
import vendingmachine.view.OutputView;

public class CoinCaseFactory {

	private static int currentAmount;

	private CoinCaseFactory() {
	}

	public static List<CoinCase> makeCoinCases(int totalAmount) {
		currentAmount = totalAmount;
		List<CoinCase> coinCases = Arrays.
			stream(Coin.values())
			.map(CoinCaseFactory::makeCoinCase)
			.collect(Collectors.toList());
		OutputView.printVendingMachineCoinStatus(coinCases);
		return coinCases;
	}

	private static CoinCase makeCoinCase(Coin coin) {
		CoinCase coinCase = new CoinCase(coin, currentAmount);
		currentAmount = coinCase.getCurrentAmount();
		return coinCase;
	}
}
