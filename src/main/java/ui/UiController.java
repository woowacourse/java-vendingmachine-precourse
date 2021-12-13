package ui;

import java.util.Map;

import vendingmachine.Coin;

public class UiController {
	private static final String QUESTION_VENDING_MACHINE_HOLD_MONEY
		= "자판기가 보유하고 있는 금액을 입력해 주세요.\n";
	private static final String QUESTION_VENDING_MACHINE_HOLD_PRODUCT
		= "\n상품명과 가격, 수량을 입력해 주세요.\n";
	private static final String QUESTION_INPUT_MONEY
		= "\n투입 금액을 입력해 주세요.\n";
	private static final String QUESTION_PRODUCT_NAME_TO_BUY
		= "구매할 상품명을 입력해 주세요.\n";
	private static final String MESSAGE_CURRENT_COIN_NUMBER
		= "\n자판기가 보유한 동전\n";
	private static final String MESSAGE_REMAIN_MONEY
		= "\n투입 금액: %d원\n";
	private static final String MESSAGE_CHANGE
		= "잔돈\n";
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

	private void printNumberOfCoins(Map<Coin, Integer> numberOfCoins) {
		for (Coin specificCoin : Coin.values()) {
			if (numberOfCoins.containsKey(specificCoin)) {
				ui.printMessage(String.format(MONEY_NUMBER, specificCoin.getAmount(), numberOfCoins.get(specificCoin)));
			}
		}
	}

	public void printCurrentCoinNumber(Map<Coin, Integer> numberOfCoins) {
		ui.printMessage(MESSAGE_CURRENT_COIN_NUMBER);
		printNumberOfCoins(numberOfCoins);
	}

	public void printLogicalExceptionError(String logicalErrorMessage) {
		ui.printMessage(logicalErrorMessage);
	}

	public String askVendingMachineHoldProduct() {
		boolean endCondition = false;
		String products = "";
		while (!endCondition) {
			products = ui.printQuestion(QUESTION_VENDING_MACHINE_HOLD_PRODUCT);
			try {
				endCondition = inputFormatChecker.checkProductSpecFormat(products);
			} catch (IllegalArgumentException e) {
				ui.printMessage(e.getMessage());
			}
		}
		return products;
	}

	public int askInputMoney() {
		boolean endCondition = false;
		String inputMoney = "";
		while (!endCondition) {
			inputMoney = ui.printQuestion(QUESTION_INPUT_MONEY);
			try {
				endCondition = inputFormatChecker.checkMoneyFormat(inputMoney);
			} catch (IllegalArgumentException e) {
				ui.printMessage(e.getMessage());
			}
		}
		return Integer.parseInt(inputMoney);
	}

	public void printRemainMoney(int money) {
		String message = String.format(MESSAGE_REMAIN_MONEY, money);
		ui.printMessage(message);
	}

	public String askProductNameToBuy() {
		return ui.printQuestion(QUESTION_PRODUCT_NAME_TO_BUY);
	}

	public void printChange(Map<Coin, Integer> change) {
		ui.printMessage(MESSAGE_CHANGE);
		printNumberOfCoins(change);
	}
}
