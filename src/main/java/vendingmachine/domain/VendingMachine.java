package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.Util;

public class VendingMachine {
	private static final VendingMachine vendingMachine = new VendingMachine();
	private Money machineMoney;
	private Products products;
	private CoinCounter machineCoinCounter;
	private ProductCounter productCounter;

	private VendingMachine() {
	}

	public static VendingMachine getInstance() {
		return vendingMachine;
	}

	public void init() {
		this.machineMoney = null;
		this.products = null;
		this.machineCoinCounter = new CoinCounter();
		this.productCounter = new ProductCounter();
	}

	public void insertMachineMoney(Money machineMoney) {
		this.machineMoney = machineMoney;
	}

	public String generateCoins() {
		int fisrtInsertedAmount = this.machineMoney.toInt();

		boolean canExchange = this.machineMoney.toInt() >= 10;

		while (canExchange) {
			int pickRangdomCoin = Util.pickRandomCoin(makeCoinKinds());
			if (!(this.machineMoney.toInt() >= pickRangdomCoin
				&& pickRangdomCoin != fisrtInsertedAmount
			)) {
				continue;
			}
			this.machineMoney.decreaseWith(pickRangdomCoin);
			this.machineCoinCounter.plusCount(Coin.findByAmount(pickRangdomCoin));

			canExchange = this.machineMoney.toInt() >= 10;
		}

		return this.machineCoinCounter.toString();
	}

	private List<Integer> makeCoinKinds() {
		return Arrays.stream(Coin.values())
			.mapToInt(Coin::toAmount)
			.boxed()
			.collect(Collectors.toList());
	}

	public void insertProducts(Products products) {
		this.products = products;
		this.productCounter.plusCountFromList(this.products.toList());
		System.out.println(productCounter);
	}
}
