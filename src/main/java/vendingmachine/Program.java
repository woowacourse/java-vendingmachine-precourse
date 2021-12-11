package vendingmachine;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public static final String PRODUCT_ENTRY_DIVIDER = ";";
	public static final String PRODUCT_ENTRY_ELEMENT_DIVIDER = ",";
	public final CoinPocket pocket;
	public final ProductTable table;
	public int userMoney;

	public Program() {
		pocket = new CoinPocket();
		table = new ProductTable();
	}

	public void start() {
		int initialMoney = setInitialMoney();
		setRandomCoins(initialMoney);
		setProductList();
		setUserMoney();
		buyProduct();
		giveChange();
	}

	private int setInitialMoney() {
		Message.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		return Integer.parseInt(moneyInString);
	}

	private void setRandomCoins(int money) {
		while (Coin.isSwappableForCoin(money)) {
			Coin coin = Coin.random(money);
			pocket.push(coin, 1);
			money = coin.subtract(money);
		}
		Message.printCoinPocket(pocket);
	}

	private void setProductList() {
		Message.ITEM_REQUEST.println();
		String productEntriesInString = Console.readLine();
		List<String> productEntries = Arrays.asList(productEntriesInString.split(PRODUCT_ENTRY_DIVIDER));
		productEntries.forEach(entry -> {
			String[] elements = entry.substring(1, entry.length() - 1).split(PRODUCT_ENTRY_ELEMENT_DIVIDER);
			table.push(elements[0], new ProductEntry(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
		});
	}

	private void setUserMoney() {
		Message.USER_MONEY_REQUEST.println();
		String userMoneyInString = Console.readLine();
		userMoney = Integer.parseInt(userMoneyInString);
	}

	private void buyProduct() {
		Message.printLeftMoney(userMoney);
		Message.PURCHASE_REQUEST.println();
		String name = Console.readLine();
		userMoney = table.buy(name, userMoney);
		if (!table.isAnythingToBuy(userMoney)) {
			return;
		}
		buyProduct();
	}

	private CoinPocket calculateChange() {
		CoinPocket change = new CoinPocket();
		for (Coin coin : Coin.values()) {
			int numberOfPoppedCoins = pocket.pop(coin, coin.divide(userMoney));
			change.push(coin, numberOfPoppedCoins);
		}
		change.removeZeros();

		return change;
	}

	private void giveChange() {
		Message.printLeftMoney(userMoney);
		Message.USER_CHANGE_SHOW.println();

		CoinPocket change = calculateChange();
		Message.printCoinPocket(change);
	}
}
