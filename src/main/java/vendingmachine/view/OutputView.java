package vendingmachine.view;

import vendingmachine.dto.BalanceDto;
import vendingmachine.dto.CoinsDto;

public class OutputView {
	private static final String ERROR = "[ERROR] ";
	private static final String COINS_HAS_VENDING_MACHINE = "자판기가 보유한 동전";
	private static final String BALANCE_HAS_VENDING_MACHINE = "투입 금액: ";
	private static final String CHANGE = "잔돈";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	public static void printLineSeparator() {
		System.out.print(System.lineSeparator());
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(ERROR + e.getMessage() + LINE_SEPARATOR);
	}

	public static void printVendingMachineHasCoinsMessage(CoinsDto coinsDto) {
		System.out.println(COINS_HAS_VENDING_MACHINE);
		System.out.println(coinsDto.toString());
	}

	public static void printVendingMachineHasBalanceMessage(BalanceDto balanceDto) {
		System.out.print(BALANCE_HAS_VENDING_MACHINE);
		System.out.println(balanceDto.toString());
	}

	public static void printVendingMachineCoinsReturnMessage(CoinsDto coinsDto) {
		System.out.println(CHANGE);
		System.out.print(coinsDto.toString());
	}
}
