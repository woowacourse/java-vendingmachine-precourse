package vendingmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinsCase {

	private final List<CoinCase> coinsCase;
	private int currentAmount;

	public CoinsCase(int vendingMachineAmount) {
		this.currentAmount = vendingMachineAmount;
		this.coinsCase = makeCoinsCase();
	}

	private List<CoinCase> makeCoinsCase() {
		List<CoinCase> coinsCase = new ArrayList<>();
		List<Coin> coinTypes = Arrays.stream(Coin.values()).collect(Collectors.toList());
		for (Coin coin : coinTypes) {
			coinsCase.add(makeCoinCase(coin));
		}
		return coinsCase;
	}

	private CoinCase makeCoinCase(Coin coin) {
		CoinCase coinCase = new CoinCase(coin, currentAmount);
		currentAmount = coinCase.getVendingMachineAmount();
		return coinCase;
	}
}
