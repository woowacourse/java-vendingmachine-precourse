package vendingmachine;

public class VendingMachine {
	private CoinBucket coinBucket;
	private Beverages beverages;

	public void powerOn() {
		init();
	}

	private void init() {
		coinBucket = initCoinBucket();
		OutputView.printCoinBucket();
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
}
