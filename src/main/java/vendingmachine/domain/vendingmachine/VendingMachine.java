package vendingmachine.domain.vendingmachine;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;

public class VendingMachine {
	private final Coins retentionCoins = new Coins();
	private final Products products = Products.from();
	private final Money insertMoney = Money.of(0);

	public void addProductAll(Products products) {
		this.products.addAll(products);
	}

	public void addRetentionCoinAll(Coins coins) {
		this.retentionCoins.addAll(coins);
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
		return retentionCoins.makeReturnChange(insertMoney);
	}
}
