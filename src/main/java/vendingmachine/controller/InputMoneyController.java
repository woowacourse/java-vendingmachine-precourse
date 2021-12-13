package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.InputMoneyModel;
import vendingmachine.validator.InputMoneyValidator;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void inputVendingMachineMoney() {
		InputMoneyView.messageInputMoney();
		String inputMoney = inputUntilValid();
		InputMoneyModel.saveMoney(inputMoney);
	}

	private String inputUntilValid() {
		String inputLine;
		do {
			inputLine = Console.readLine();
		} while (!InputMoneyValidator.checkInputMoney(inputLine));
		return inputLine;
	}
}
