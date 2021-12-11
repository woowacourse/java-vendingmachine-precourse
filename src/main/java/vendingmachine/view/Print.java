package vendingmachine.view;

public class Print {
	private static final String INSERT_MONEY_OF_CHANGES = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String COUNT_OF_COINS_TITLE = "자판기가 보유한 동전";

	private static final String MONEY_UNIT = "원";
	private static final String COIN_UNIT = "개";
	private static final String COIN_AND_COUNT_SPLIT_SYMBOL = " - ";


	public static void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printInsertMoneyOfChanges() {
		System.out.println(INSERT_MONEY_OF_CHANGES);
	}

	public static void printCountOfCoinsTitle() {
		System.out.println();
		System.out.println(COUNT_OF_COINS_TITLE);
	}

	public static void printCountOfCoins(int amount, int count) {
		System.out.println(amount + MONEY_UNIT + COIN_AND_COUNT_SPLIT_SYMBOL + count + COIN_UNIT);
	}
}
