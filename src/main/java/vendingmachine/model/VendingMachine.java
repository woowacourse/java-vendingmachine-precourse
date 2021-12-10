package vendingmachine.model;

import java.util.List;

public class VendingMachine {

	private final List<CoinCase> coinsCase;
	private final List<Product> products;

	public VendingMachine(List<CoinCase> coinCases, List<Product> products) {
		this.coinsCase = coinCases;
		this.products = products;
	}
}
