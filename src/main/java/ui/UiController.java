package ui;

import java.util.Map;

import vendingmachine.Coin;

public class UiController {
	private static final String QUESTION_VENDING_MACHINE_HOLD_MONEY
		= "자판기가 보유하고 있는 금액을 입력해 주세요.\n";
	private static final String MESSAGE_CURRENT_COIN_NUMBER
		= "\n자판기가 보유한 동전\n";
	private static final String MONEY_NUMBER
		= "%d원 - %d개\n";

	private Ui ui;
	private InputFormatChecker inputFormatChecker;

	public UiController() {
		ui = new Ui();
		inputFormatChecker = new InputFormatChecker();
	}

	public int askVendingMachineHoldMoneyAmount() {
		boolean endCondition = false;
		String money = "";
		while (!endCondition) {
			money = ui.printQuestion(QUESTION_VENDING_MACHINE_HOLD_MONEY);
			try {
				endCondition = inputFormatChecker.checkMoneyFormat(money);
			} catch (IllegalArgumentException e) {
				ui.printMessage(e.getMessage());
			}
		}
		return Integer.parseInt(money);
	}

	public void printCurrentCoinNumber(Map<Coin, Integer> numberOfCoins) {
		ui.printMessage(MESSAGE_CURRENT_COIN_NUMBER);
		for (Coin specificCoin : Coin.values()) {
			ui.printMessage(String.format(MONEY_NUMBER, specificCoin.getAmount(), numberOfCoins.get(specificCoin)));
		}
	}

	public void printLogicalExceptionError(String logicalErrorMessage) {
		ui.printMessage(logicalErrorMessage);
	}
}
