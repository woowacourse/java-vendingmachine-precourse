package vendingmachine.view;

public class OutputView {
	public static void printHoldingAmountCoin(String holdingAmountCoinToString) {
		System.out.println("자판기가 보유한 동전");
		System.out.println(holdingAmountCoinToString);
		printEmptyLine();
	}

	public static void printInputAmount(int inputAmount) {
		System.out.println("투입 금액: " + inputAmount);
	}

	private static void printEmptyLine() {
		System.out.println();
	}
}
