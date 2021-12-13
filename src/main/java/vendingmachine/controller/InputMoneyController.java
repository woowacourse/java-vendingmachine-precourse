package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.InputMoneyModel;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void inputVendingMachineMoney() {
		InputMoneyView.messageInputMoney();
		InputMoneyModel.saveMoney(inputUntilValid());
	}

	public void inputUserMoney() {
		InputMoneyView.messageInputUserMoney();
		InputMoneyModel.saveUserMoney(inputUntilValid());
	}

	private String inputUntilValid() {
		String inputLine;
		do {
			inputLine = Console.readLine();
		} while (!MoneyValidator.checkInputMoney(inputLine));
		return inputLine;
	}
}
