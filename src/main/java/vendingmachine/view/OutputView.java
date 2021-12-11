package vendingmachine.view;

public class OutputView {
	public static void printHoldingAmountCoin(String holdingAmountCoinToString) {
		System.out.println("자판기가 보유한 동전");
		System.out.println(holdingAmountCoinToString);
	}

	public static void printInputAmount(int inputAmount) {
		System.out.println("투입 금액: " + inputAmount + "원");
	}

	public static void printChangeAmount(String changeAmountToString) {
		System.out.println("잔돈");
		System.out.println(changeAmountToString);
	}
}
