package vendingmachine.view;

public class VendingMachineView {

	public static final String INPUT_MONEY_FOR_CHANGE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public void inputMoneyForChange() {
		System.out.println(INPUT_MONEY_FOR_CHANGE_MESSAGE);
	}

	public void makeEmptyLine() {
		System.out.println();
	}
}
