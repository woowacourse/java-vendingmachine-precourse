package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

/**
 * 자판기의 처리 흐름을 제어하는 controller class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Machine {
	private Display display;
	private Validator validator;
	private Cashier cashier;

	public Machine() {
		this.display = new Display();
		this.validator = new Validator();
		this.cashier = new Cashier();
	}

	public void run() {
		prepareCoins();
	}

	private void prepareCoins() {
		cashier.makeCoins(askHoldingAmount());
		display.printBlankLine();
		display.printAllCoin();
		display.printBlankLine();
	}

	private int askHoldingAmount() {
		display.askHoldingAmount();
		try {
			return validator.validateAmountInput(Console.readLine());
		} catch (IllegalArgumentException e) {
			display.printError(e);
			return askHoldingAmount();
		}
	}
}
