package vendingmachine.io;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.data.VendingMachineData;
import vendingmachine.io.validator.InputValidator;

public class InputHandler {

	OutputHandler outputHandler;

	private String read() {
		return Console.readLine();
	}

	public InputHandler(OutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	public int getValidMoney() {
		outputHandler.printMessage(VendingMachineData.INPUT_VENDING_MACHINE_MONEY_MESSAGE);
		return getMoney();
	}

	private int getMoney() {
		String data = read();
		InputValidator.validMoneyValue(data);
		return Integer.parseInt(data);
	}

}
