package vendingmachine.service;

import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.coin.RandomCoinGenerator;
import vendingmachine.domain.money.Money;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.vendingmachine.VendingMachine;

public class VendingMachineService {
	private final VendingMachine vendingMachine = new VendingMachine();

	public Coins saveRetentionCoins(Money retentionMoney) {
		CoinGenerator coinGenerator = new RandomCoinGenerator();
		Coins retentionCoins = coinGenerator.generate(retentionMoney);
		vendingMachine.addRetentionCoinAll(retentionCoins);
		return retentionCoins;
	}

	public void saveProducts(Products products) {
		vendingMachine.addProductAll(products);
	}

	public void saveInsertMoney(Money money) {
		vendingMachine.insert(money);
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

	public Coins createReturnChange() {
		return vendingMachine.returnChange();
	}
}
