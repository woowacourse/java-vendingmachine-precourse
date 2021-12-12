package vendingmachine;

import vendingmachine.coin.Coins;
import vendingmachine.product.Products;

public class VendingMachine {
	private final Coins coins = new Coins();
	private final Products products = Products.from();
	private final Money insertMoney = Money.of(0);

	public static VendingMachine from() {
		return new VendingMachine();
	}

	public void addProductAll(Products products) {
		products.addAll(products);
	}

	public void addCoinAll(Coins coins) {
		coins.addAll(coins);
	}

	public void insert(Money money) {
		insertMoney.earn(money);
	}

	public Money getInsertMoney() {
		return insertMoney;
	}

	public void purchase(String productName) {
		Money productPrice = products.purchaseProduct(productName);
		insertMoney.spend(productPrice);
	}

	public boolean isPurchasable() {
		return products.isPurchasable(insertMoney);
	}

	public Coins returnChange() {
		return coins.returnChange(insertMoney);
	}
}
