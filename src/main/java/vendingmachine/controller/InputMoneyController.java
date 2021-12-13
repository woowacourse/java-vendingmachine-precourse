package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.MoneyModel;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.view.MoneyView;

public class InputMoneyController {
	public void inputVendingMachineMoney() {
		MoneyView.messageInputMoney();
		MoneyModel.saveMoney(inputUntilValid());
	}

	public void inputUserMoney() {
		MoneyView.messageInputUserMoney();
		MoneyModel.saveUserMoney(inputUntilValid());
	}

	private String inputUntilValid() {
		String inputLine;
		do {
			inputLine = Console.readLine();
		} while (!MoneyValidator.checkInputMoney(inputLine));
		return inputLine;
	}
}
