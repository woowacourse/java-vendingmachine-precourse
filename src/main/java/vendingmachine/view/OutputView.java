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
	private static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
	private static final String CHECK_CURRENT_USER_MONEY = "투입 금액: ";
	private static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";
	private static final String RETURN_COINS = "잔돈";
	private static final String ERROR = "[ERROR] ";

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
		System.out.println(ERROR + exception.getMessage());
	}

	public static void printInputMoney() {
		printNewLine();
		System.out.println(INPUT_MONEY);
	}

	public static void printCurrentUserMoney(int userMoney) {
		printNewLine();
		System.out.println(CHECK_CURRENT_USER_MONEY + userMoney + WON);
	}

	public static void printInputPurchaseProduct() {
		System.out.println(INPUT_PURCHASE_PRODUCT);
	}

	public static void printChange(VendingMachineCoins changeCoins) {
		System.out.println(RETURN_COINS);
		for (Coin coin : changeCoins.getKeys()) {
			if (changeCoins.hasCoin(coin)) {
				System.out.println(coin.getAmount() + WON + DASH + changeCoins.getAmount(coin) + EA);
			}
		}
	}
}
