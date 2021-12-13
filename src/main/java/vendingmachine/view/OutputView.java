package vendingmachine.view;

import java.util.Map;
import vendingmachine.model.Changes;
import vendingmachine.model.CoinCase;
import vendingmachine.model.VendingMachine;

public class OutputView {

	private static final int INITIAL_VALUE = 0;
	private static final String ASK_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String VENDING_MACHINE_COIN_STATUS = "자판기가 보유한 동전";
	private static final String ASK_PRODUCT_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String KOREAN_CURRENCY = "원";
	private static final String UNIT_OF_COUNTING_COINS = "개";
	private static final String DELIMITER_COIN_AND_NUMBER = " - ";
	private static final String ASK_INSERT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String NOTICE_INSERTED_MONEY = "투입 금액: ";
	private static final String ASK_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
	private static final String CHANGE = "잔돈";

	private OutputView() {
	}

	public static void printError(IllegalArgumentException IAE) {
		printNewLine();
		System.out.print(IAE.getMessage());
	}

	public static void askVendingMachineAmount() {
		printNewLine();
		System.out.println(ASK_VENDING_MACHINE_AMOUNT);
	}

	public static void printVendingMachineCoinStatus(CoinCase coinCase) {
		printCoinStatus();
		coinCase.getCoinCase().
			entrySet().
			stream().
			sorted(Map.Entry.comparingByKey()).
			forEach(entry -> System.out.println(entry.getKey().getAmount()
				+ KOREAN_CURRENCY
				+ DELIMITER_COIN_AND_NUMBER
				+ entry.getValue()
				+ UNIT_OF_COUNTING_COINS));
	}

	public static void askProductInfo() {
		printNewLine();
		System.out.println(ASK_PRODUCT_INFORMATION);
	}

	private static void printCoinStatus() {
		printNewLine();
		System.out.println(VENDING_MACHINE_COIN_STATUS);
	}

	public static void askInsertMoney() {
		printNewLine();
		System.out.println(ASK_INSERT_MONEY);
	}

	public static void printInsertedMoney(VendingMachine vendingMachine) {
		printNewLine();
		System.out.print(
			NOTICE_INSERTED_MONEY + vendingMachine.getRemainInsertMoney() + KOREAN_CURRENCY);
	}

	public static void askProductToBuy() {
		printNewLine();
		System.out.println(ASK_PRODUCT_NAME);
	}

	public static void printChanges(Changes changes) {
		printNewLine();
		System.out.println(CHANGE);
		changes.getChanges().entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey())
			.filter(coin -> coin.getValue() > INITIAL_VALUE)
			.forEach(entry ->
				System.out.println(entry.getKey().getAmount()
					+ KOREAN_CURRENCY
					+ DELIMITER_COIN_AND_NUMBER
					+ entry.getValue()
					+ UNIT_OF_COUNTING_COINS));
	}

	private static void printNewLine() {
		System.out.println();
	}
}
