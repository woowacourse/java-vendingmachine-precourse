package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public final CoinPocket coinPocket;
	public final ProductTable productTable;
	public int userMoney;

	public Program() {
		coinPocket = new CoinPocket();
		productTable = new ProductTable();
	}

	public void start() {
		int initialMoneyInMachine = InitialMoney.get();
		setRandomCoinsInPocketWithMoney(initialMoneyInMachine);
		productTable.setProductTable();
		userMoney = UserMoney.get();
		buyProductUntilFailure();
		Change.giveChange(coinPocket, userMoney);
	}

	private void setRandomCoinsInPocketWithMoney(int money) {
		while (Coin.isSwappableForCoin(money)) {
			Coin randomCoin = Coin.pickRandom(money);
			coinPocket.pushSingle(randomCoin);
			money = randomCoin.subtract(money);
		}
		Guide.INITIAL_COIN_CHANGE_SHOW.println();
		Guide.printCoinPocket(coinPocket);
	}

	private void buyProductUntilFailure() {
		String name = getProductName();
		if (!productTable.isAffordableProduct(name, userMoney)) {
			return;
		}
		productTable.buy(name);
		userMoney = productTable.getLeftMoney(name, userMoney);
		if (!productTable.isAnythingToBuy(userMoney)) {
			return;
		}
		buyProductUntilFailure();
	}

	private String getProductName() {
		Guide.printLeftMoney(userMoney);
		Guide.PURCHASE_REQUEST.println();
		String productName = Console.readLine().trim();
		PurchaseProductNameValidator validator = new PurchaseProductNameValidator();
		if (!validator.validate(productName, productTable)) {
			return getProductName();
		}
		return productName;
	}
}
