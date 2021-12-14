package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum Guide {
	INITIAL_MONEY_REQUEST("자판기가 보유하고 있는 금액을 입력해 주세요."),
	ITEM_REQUEST("\n상품명과 가격, 수량을 입력해 주세요."),
	USER_MONEY_REQUEST("\n투입 금액을 입력해 주세요."),
	PURCHASE_REQUEST("구매할 상품명을 입력해 주세요."),
	INITIAL_COIN_CHANGE_SHOW("\n자판기가 보유한 동전"),
	LEFT_MONEY_SHOW("\n투입 금액: "),
	USER_CHANGE_SHOW("잔돈");

	public static final String NUMBER = "개";
	public static final String LEFT_MONEY_FORMAT = "%s원\n";
	private final String message;

	Guide(final String message) {
		this.message = message;
	}

	public static void printCoinPocket(final CoinPocket pocket) {
		Set<Map.Entry<Coin, Integer>> pocketInSet = pocket.getEntries();
		List<String> messageBag = new ArrayList<>();
		pocketInSet.forEach(entry -> messageBag.add(makeCoinMessage(entry)));
		System.out.println(String.join(Constants.LINE_FEED, messageBag));
	}

	private static String makeCoinMessage(final Map.Entry<Coin, Integer> entry) {
		List<String> wordBag = new ArrayList<>();
		wordBag.add(entry.getKey().message);
		wordBag.add(Constants.HYPHEN);
		wordBag.add(entry.getValue().toString() + NUMBER);
		return String.join(" ", wordBag);
	}

	public static void printLeftMoney(final int money) {
		LEFT_MONEY_SHOW.print();
		System.out.printf(LEFT_MONEY_FORMAT, money);
	}

	public void print() {
		System.out.print(message);
	}

	public void println() {
		System.out.println(message);
	}
}
