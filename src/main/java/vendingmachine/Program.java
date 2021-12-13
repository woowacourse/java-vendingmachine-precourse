package vendingmachine;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public static final String PRODUCT_ENTRY_DIVIDER = ";";
	public static final String PRODUCT_ENTRY_ELEMENT_DIVIDER = ",";
	public static final int UNDER_BOUND_CHAR_TO_BE_NUMBER = 0;
	public static final int UPPER_BOUND_CHAR_TO_BE_NUMBER = 9;

	public final CoinPocket coinPocket;
	public final ProductTable productTable;
	public int userMoney;

	public Program() {
		coinPocket = new CoinPocket();
		productTable = new ProductTable();
	}

	public void start() {
		int initialMoneyInMachine = setInitialMoneyInMachine();
		setRandomCoinsInPocketWithMoney(initialMoneyInMachine);
		setProductTable();
		setUserMoney();
		buyProductUntilFailure();
		giveChange();
	}

	private int setInitialMoneyInMachine() throws IllegalArgumentException {
		Guide.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		return Integer.parseInt(moneyInString);
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

	private void setProductTable() {
		Guide.ITEM_REQUEST.println();
		String productEntriesInString = Console.readLine();
		List<String> productEntries = Arrays.asList(productEntriesInString.split(PRODUCT_ENTRY_DIVIDER));
		productEntries.forEach(entry -> {
			String[] elements = entry.substring(1, entry.length() - 1).split(PRODUCT_ENTRY_ELEMENT_DIVIDER);
			productTable.push(elements[0],
				new ProductEntry(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
		});
	}

	private void setUserMoney() {
		Guide.USER_MONEY_REQUEST.println();
		String userMoneyInString = Console.readLine();
		userMoney = Integer.parseInt(userMoneyInString);
	}

	private String getProductName() {
		return Console.readLine();
	}

	private void buyProductUntilFailure() {
		Guide.printLeftMoney(userMoney);
		Guide.PURCHASE_REQUEST.println();
		String name = getProductName();
		productTable.buy(name);
		userMoney = productTable.getLeftMoney(name, userMoney);
		if (!productTable.isAnythingToBuy(userMoney)) {
			return;
		}
		buyProductUntilFailure();
	}

	private CoinPocket calculateChange() {
		CoinPocket change = new CoinPocket();
		for (Coin coin : Coin.values()) {
			int numberOfPoppedCoins = coinPocket.pop(coin, coin.divide(userMoney));
			change.push(coin, numberOfPoppedCoins);
		}

		return change;
	}

	private void giveChange() {
		Guide.printLeftMoney(userMoney);
		Guide.USER_CHANGE_SHOW.println();
		CoinPocket change = calculateChange();
		change.removeCoinsOfZeroNumber();
		Guide.printCoinPocket(change);
	}
}
