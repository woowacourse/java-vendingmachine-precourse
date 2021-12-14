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

		//2.[ db속 존재유무 & 1개이상 유무]는 이미 검증이 된 체로왔음.(반복에서 입력시마다 검증함)
		// [보유중인 돈 >= 상품 금액] 이어야한다. -> 이것도 입력시 추가 검사..

	}

	public boolean isProductAvailable(Product product) {
		return this.productCounter.isAvailable(product);
	}

	public boolean isUserPurchasable(Product product) {
		return this.userMoney.isOrGreaterThan(product);

	}
}
