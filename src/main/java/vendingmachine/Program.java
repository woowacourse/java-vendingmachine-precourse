package vendingmachine;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public static final String PRODUCT_ENTRY_DIVIDER = ";";
	public static final String PRODUCT_ENTRY_ELEMENT_DIVIDER = ",";
	public final CoinPocket pocket;
	public final ProductTable table;

	public Program() {
		pocket = new CoinPocket();
		table = new ProductTable();
		int initialMoney = setInitialMoney();
		makeRandomCoins(initialMoney);
		setProductList();
	}

	private int setInitialMoney() {
		Message.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		return Integer.parseInt(moneyInString);
	}

	private void makeRandomCoins(int money) {
		while (Coin.isSwappableForCoin(money)) {
			Coin coin = Coin.random(money);
			pocket.push(coin);
			money = coin.subtract(money);
		}

		Message.printCoinPocket(pocket);
	}

	private void setProductList() {
		Message.ITEM_REQUEST.println();
		String productEntriesInString = Console.readLine();
		List<String> productEntries = Arrays.asList(productEntriesInString.split(PRODUCT_ENTRY_DIVIDER));
		productEntries.forEach(entry -> {
			String[] elements = entry.substring(1, entry.length() - 2).split(PRODUCT_ENTRY_ELEMENT_DIVIDER);
			table.push(elements[0], new ProductEntry(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
		});
	}
}
