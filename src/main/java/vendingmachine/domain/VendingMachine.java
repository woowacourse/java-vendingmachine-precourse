package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vendingmachine.utils.Constant;
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
		boolean canExchange = isEnoughMachineMoneyThanCoinAmount(Constant.LOWEST_COIN_AMOUNT);
		while (canExchange) {
			int pickRangdomCoin = Util.pickRandomCoin(makeCoinKinds());
			if (isEnoughExchangeDemands(fisrtInsertedAmount, pickRangdomCoin))
				continue;
			this.machineMoney.decreaseWith(pickRangdomCoin);
			this.machineCoinCounter.plusCount(Coin.findByAmount(pickRangdomCoin));
			canExchange = isEnoughMachineMoneyThanCoinAmount(Constant.LOWEST_COIN_AMOUNT);
		}
		return this.machineCoinCounter.toString();
	}

	private boolean isEnoughExchangeDemands(int fisrtInsertedAmount, int pickRangdomCoin) {
		return !(isEnoughMachineMoneyThanCoinAmount(pickRangdomCoin)
			&& isNotSameInsertMoney(fisrtInsertedAmount, pickRangdomCoin));
	}

	private boolean isEnoughMachineMoneyThanCoinAmount(int pickRangdomCoin) {
		return this.machineMoney.toInt() >= pickRangdomCoin;
	}

	private boolean isNotSameInsertMoney(int fisrtInsertedAmount, int pickRangdomCoin) {
		return pickRangdomCoin != fisrtInsertedAmount;
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
		Product product = this.products.findProductByName(wantedProductName.toString());
		this.userMoney.decreaseWith(product.toAmount());
		this.productCounter.minusCount(product);
	}

	public boolean isProductAvailable(Product product) {
		return this.productCounter.isAvailable(product);
	}

	public boolean isUserPurchasable(Product product) {
		return this.userMoney.isOrGreaterThan(product);

	}

	public boolean canSale() {
		boolean isValidUserMoney = this.userMoney.toInt() >= this.products.findMinAmount();
		boolean anyProductAvailable = this.productCounter.isAnyAvailable();
		return isValidUserMoney && anyProductAvailable;
	}

	public int toCurrentUserMoney() {
		return this.userMoney.toInt();
	}

	public String returnCoins() {
		CoinCounter userReturnCoinCounter = new CoinCounter();
		exChangeProcess(userReturnCoinCounter);
		this.machineMoney.increaseWith(this.userMoney.toInt());
		return returnCoinToStates(userReturnCoinCounter);
	}

	private void exChangeProcess(CoinCounter userReturnCoinCounter) {
		this.machineCoinCounter.forEach((coin, count) -> {
			IntStream.rangeClosed(Constant.CONSTANT_ONE, count)
				.forEach(i -> {
					int coinAmount = coin.toAmount();
					if (isReturnable()) {
						this.userMoney.decreaseWith(coinAmount);
						this.machineCoinCounter.minusCount(coin);
						userReturnCoinCounter.plusCount(coin);
					}
				});
		});
	}

	private boolean isReturnable() {
		return this.userMoney.toInt() >= Constant.LOWEST_COIN_AMOUNT && this.machineCoinCounter.isAnyAvailable();
	}

	private String returnCoinToStates(CoinCounter userReturnCoinCounter) {
		if (!userReturnCoinCounter.isAnyAvailable()) {
			return Constant.EMPTY_STRING;
		}
		return userReturnCoinCounter.toReturnCoinString();
	}
}
