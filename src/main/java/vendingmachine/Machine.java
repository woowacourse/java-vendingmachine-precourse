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

	public Machine() {
		this.display = new Display();
		this.validator = new Validator();
	}

	public void run() {
		prepareCoins();
	}

	private void prepareCoins() {
		int holdingAmount = askHoldingAmount();
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
