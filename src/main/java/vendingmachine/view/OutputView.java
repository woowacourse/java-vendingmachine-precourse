package vendingmachine.view;

public class OutputView {
	public static final String PRINT_SCREEN_HOLDING_AMOUNT_COIN = "자판기가 보유한 동전";
	public static final String PRINT_SCREEN_CHANGE_AMOUNT = "잔돈";

	public static void printHoldingAmountCoin(String holdingAmountCoinToString) {
		System.out.println(PRINT_SCREEN_HOLDING_AMOUNT_COIN);
		System.out.println(holdingAmountCoinToString);
	}

	public static void printInputAmount(int inputAmount) {
		System.out.println("투입 금액: " + inputAmount + "원");
	}

	public static void printChangeAmount(String changeAmountToString) {
		System.out.println(PRINT_SCREEN_CHANGE_AMOUNT);
		System.out.println(changeAmountToString);
	}
}
