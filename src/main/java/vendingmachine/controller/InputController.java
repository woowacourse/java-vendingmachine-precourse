package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputController {
	public int scanHoldingMoney() {
		while (true) {
			try {
				InputView.askHoldingMoney();
				String holdingMoney = Console.readLine();
				int money = InputValidator.isNumber(holdingMoney);
				return money;
			} catch (IllegalArgumentException e) {
				OutputView.printMoneyError();
			}
		}
	}
}
