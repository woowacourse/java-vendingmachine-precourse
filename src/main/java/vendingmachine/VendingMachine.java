package vendingmachine;

public class VendingMachine {
	private CoinBucket coinBucket;
	private Beverages beverages;

	public void powerOn() {
		init();
	}

	private void init() {
		coinBucket = initCoinBucket();
		OutputView.printCoinBucket(coinBucket.getCoins());
		beverages = initBeverages();
	}

	private CoinBucket initCoinBucket() {
		try {
			return getCoinBucketFromInput();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initCoinBucket();
		}
	}

	private CoinBucket getCoinBucketFromInput() {
		int assetsInput = InputView.readInitialMachineAssets();
		Money machineAssets = Money.from(assetsInput);
		return CoinBucket.of(machineAssets, new RandomCoinGenerator());
	}

	private Beverages initBeverages() {
		try {
			return getBeveragesFromInput();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initBeverages();
		}
	}

	private Beverages getBeveragesFromInput() {
		String beverageInfos = InputView.readBeverageInfos();
		return BeverageShop.getBeverages(beverageInfos);
	}
}
