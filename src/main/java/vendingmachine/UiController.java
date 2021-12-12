package vendingmachine;

public class UiController {
	private static final String QUESTION_VENDING_MACHINE_HOLD_MONEY
		= "자판기가 보유하고 있는 금액을 입력해 주세요.\n";
	private static final String ERROR_MESSAGE_MONEY_FORMAT
		= "[ERROR] 금액은 10원 단위의 숫자로 입력해 주세요.\n";

	private Ui ui;
	private InputFormatChecker inputFormatChecker;

	UiController() {
		ui = new Ui();
		inputFormatChecker = new InputFormatChecker();
	}

	protected int askVendingMachineHoldMoneyAmount() {
		boolean endCondition = false;
		String money = "";
		while (!endCondition) {
			money = ui.printQuestion(QUESTION_VENDING_MACHINE_HOLD_MONEY);
			try {
				endCondition = inputFormatChecker.checkMoneyFormat(money);
			} catch (IllegalArgumentException e) {
				ui.printMessage(ERROR_MESSAGE_MONEY_FORMAT);
			}
		}
		return Integer.parseInt(money);
	}
}
