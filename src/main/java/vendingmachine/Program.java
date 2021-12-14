package vendingmachine;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public static final String PRODUCT_ENTRY_SEPARATOR = ";";
	public static final String PRODUCT_ENTRY_ELEMENT_SEPARATOR = ",";
	public static final int INDEX_OF_PRODUCT_NAME = 0;
	public static final int INDEX_OF_PRODUCT_PRICE = 1;
	public static final int INDEX_OF_PRODUCT_NUMBER = 2;
	private static final int BRACKET_CHAR_LENGTH = 1;

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
		return Integer.parseInt(getInitialMoney());
	}

	private String getInitialMoney() throws IllegalArgumentException {
		Guide.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		InitialMoneyValidator validator = new InitialMoneyValidator();
		if (!validator.validate(moneyInString)) {
			return getInitialMoney();
		}
		return moneyInString;
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
		List<String> productEntries = getProductEntries();
		productEntries.forEach(entry -> {
			String entryWithoutBlank = entry.trim();
			String[] elements = entryWithoutBlank
				.substring(BRACKET_CHAR_LENGTH, entryWithoutBlank.length() - BRACKET_CHAR_LENGTH)
				.split(PRODUCT_ENTRY_ELEMENT_SEPARATOR);
			productTable.push(elements[INDEX_OF_PRODUCT_NAME].trim(),
				new ProductEntry(Integer.parseInt(elements[INDEX_OF_PRODUCT_PRICE].trim()),
					Integer.parseInt(elements[INDEX_OF_PRODUCT_NUMBER].trim())));
		});
	}

	private List<String> getProductEntries() {
		Guide.ITEM_REQUEST.println();
		String productEntriesInString = Console.readLine();
		ProductEntrySyntacticValidator syntacticValidator = new ProductEntrySyntacticValidator();
		ProductEntrySemanticValidator semanticValidator = new ProductEntrySemanticValidator();
		List<String> productEntries = Arrays.asList(productEntriesInString.split(PRODUCT_ENTRY_SEPARATOR));
		if (!syntacticValidator.validate(productEntries)
			|| !semanticValidator.validate((productEntries))) {
			return getProductEntries();
		}
		return productEntries;
	}

	private void setUserMoney() {
		String userMoneyInString = getUserMoney();
		userMoney = Integer.parseInt(userMoneyInString);
	}

	private String getUserMoney() {
		Guide.USER_MONEY_REQUEST.println();
		String userMoneyInString = Console.readLine();
		UserMoneyValidator validator = new UserMoneyValidator();
		if (!validator.validate(userMoneyInString)) {
			return getUserMoney();
		}
		return userMoneyInString;
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

	private void giveChange() {
		Guide.printLeftMoney(userMoney);
		Guide.USER_CHANGE_SHOW.println();
		CoinPocket change = calculateChange();
		change.removeCoinsOfZeroNumber();
		Guide.printCoinPocket(change);
	}

	private CoinPocket calculateChange() {
		CoinPocket change = new CoinPocket();
		for (Coin coin : Coin.values()) {
			int numberOfPoppedCoins = coinPocket.pop(coin, coin.divide(userMoney));
			userMoney = coin.subtractByGivenNumberOfCoins(userMoney, numberOfPoppedCoins);
			change.push(coin, numberOfPoppedCoins);
		}

		return change;
	}
}
