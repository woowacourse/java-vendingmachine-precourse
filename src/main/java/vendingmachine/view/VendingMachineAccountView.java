package vendingmachine.view;

public class VendingMachineAccountView {
	private static final String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static void printInputGuide() {
		System.out.println(INPUT_MESSAGE);
	}

	public static void printCoinList(int coinUnit, Integer amount) {
		System.out.println(coinUnit + "원 - " + amount + "개");
	}
}
