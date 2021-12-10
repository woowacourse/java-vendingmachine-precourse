package vendingmachine.model;

import java.util.List;

public class VendingMachine {

	private final List<CoinCase> coinsCase;
	private final List<Product> products;
	private final int insertMoney;

	public VendingMachine(List<CoinCase> coinCases, List<Product> products, int insertMoney) {
		this.coinsCase = coinCases;
		this.products = products;
		this.insertMoney = insertMoney;
	}

	public int getInsertMoney() {
		return insertMoney;
	}

	public List<Product> getProducts() {
		return products;
	}
}
