package vendingmachine.view;

import vendingmachine.domain.VendingMachineCoins;
import vendingmachine.type.Coin;

public class OutputView {

	private static final String INPUT_VENDING_MACHINE_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
	private static final String WON = "원";
	private static final String DASH = " - ";
	private static final String EA = "개";
	private static final String INPUT_PRODUCT = "상품명과 가격, 수량을 입력해 주세요.";

	public static void printInputVendingMachineCoin() {
		System.out.println(INPUT_VENDING_MACHINE_COIN);
	}

	public static void printVendingMachineCoins(VendingMachineCoins vendingMachineCoins) {
		printNewLine();
		System.out.println(VENDING_MACHINE_COINS);
		for (Coin coin : vendingMachineCoins.getKeys()) {
			System.out.println(coin.getAmount() + WON + DASH + vendingMachineCoins.getAmount(coin) + EA);
		}
	}

	private static void printNewLine() {
		System.out.println();
	}

	public static void printInputProduct() {
		printNewLine();
		System.out.println(INPUT_PRODUCT);
	}

	public static void printException(Exception exception) {
		System.out.println(exception.getMessage());
	}
}
