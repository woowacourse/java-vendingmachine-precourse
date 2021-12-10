package vendingmachine.view;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Coin;
import vendingmachine.model.CoinCase;

public class OutputView {

	private static final int INITIAL_VALUE = 0;
	private static final String ASK_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String VENDING_MACHINE_COIN_STATUS = "자판기가 보유한 동전";
	private static final String ASK_PRODUCT_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String KOREAN_CURRENCY = "원";
	private static final String DELIMITER_COIN_AND_NUMBER = " - ";
	private static final String ASK_INSERT_MONEY = "투입 금액을 입력해 주세요.";

	private OutputView() {
	}

	public static void printError(IllegalArgumentException IAE) {
		System.out.println(IAE.getMessage());
	}

	public static void askVendingMachineAmount() {
		System.out.println(ASK_VENDING_MACHINE_AMOUNT);
	}

	public static void printVendingMachineCoinStatus(List<CoinCase> coinsCase) {
		printCoinStatus();
		List<Integer> coinTypes = coinsCase.stream().map(CoinCase::getCoin)
			.map(Coin::getAmount).collect(
				Collectors.toList());
		List<Integer> numberOfCoins = coinsCase.stream().map(CoinCase::getNumber)
			.collect(
				Collectors.toList());
		for (int i = INITIAL_VALUE; i < coinTypes.size(); i++) {
			System.out.println(coinTypes.get(i) + KOREAN_CURRENCY + DELIMITER_COIN_AND_NUMBER
				+ numberOfCoins.get(i));
		}
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

	private static void printNewLine() {
		System.out.println();
	}
}
