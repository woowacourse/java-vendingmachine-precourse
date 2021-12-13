package vendingmachine.domain.machine;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;

public class VendingMachine {
	private Coins coins;
	private Products products;
	private Balance balance;

	private VendingMachine(Coins coins, Products products, Balance balance) {
		this.coins = coins;
		this.products = products;
		this.balance = balance;
	}

	public static VendingMachine of(Coins coins, Products products, Balance balance) {
		return new VendingMachine(coins, products, balance);
	}

	public void purchaseProduct(String productName) {
		final Product product = products.isCheckSameProduct(productName);
		balance = product.purchase(balance);
	}

	public boolean isContinueVendingMachine() {
		if (balance.isValidateHasBalanceZero() || products.isValidateProductsPurchase(balance)) {
			return false;
		}

		return true;
	}

	public Balance getHasBalance() {
		return balance;
	}

	public Coins getReturnCoins() {
		return coins.calculateReturnCoins(balance);
	}
}
