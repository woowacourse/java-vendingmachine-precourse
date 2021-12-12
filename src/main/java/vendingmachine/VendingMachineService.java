package vendingmachine;

import vendingmachine.coin.CoinGenerator;
import vendingmachine.coin.Coins;
import vendingmachine.coin.RandomCoinGenerator;
import vendingmachine.product.Products;

public class VendingMachineService {
	private final VendingMachine vendingMachine = new VendingMachine();

	public Coins generateCoin(Money retentionMoney) {
		CoinGenerator coinGenerator = new RandomCoinGenerator();
		Coins generateCoins = coinGenerator.generate(retentionMoney);
		vendingMachine.addCoinAll(generateCoins);
		return generateCoins;
	}

	public void addProducts(Products products) {
		vendingMachine.addProductAll(products);
	}

	public void insert(Money insertMoney) {
		vendingMachine.insert(insertMoney);
	}

	public Money getInsertMoney() {
		return vendingMachine.getInsertMoney();
	}

	public boolean isPurchasable() {
		return vendingMachine.isPurchasable();
	}

	public void purchaseProduct(String productName) {
		vendingMachine.purchase(productName);
	}

	public Coins showReturnChange() {
		return vendingMachine.returnChange();
	}
}
