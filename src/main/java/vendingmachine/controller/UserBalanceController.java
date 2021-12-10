package vendingmachine.controller;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class UserBalanceController {
	public void generateUserBalance() {
		String input = InputView.inputUserBalance();
		try {
			UserBalance.from(input);
			// TODO: Service 호출 로직 추가
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateUserBalance();
		}
	}
}
