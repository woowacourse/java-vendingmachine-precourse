package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.Util;

public class VendingMachine {
	private static final VendingMachine vendingMachine = new VendingMachine();
	private Money machineMoney;
	private Money userMoney;
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
		this.userMoney = null;
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
	}

	public void insertUserMoney(Money userMoney) {
		this.userMoney = userMoney;
	}

	public Product findProductByName(String inputValue) {
		return this.products.findProductByName(inputValue);
	}

	public void sale(Name wantedProductName) {
		//1. 일단은 일부정보(name) -> 객체를찾아야함.
		Product product = this.products.findProductByName(wantedProductName.toString());

		//2. 구매조건
		//(1) 해당객체가 >1 인가..  이것도 입력받을때 검증하기..

	}

	public boolean isProductAvailable(Product product) {
		return this.productCounter.isAvailable(product);
	}
}
