package vendingmachine.controller;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.service.UserBalanceService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class UserBalanceController {
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateUserBalance() {
		String input = InputView.inputUserBalance();
		try {
			UserBalance userBalance = UserBalance.from(input);
			userBalanceService.initUserBalance(userBalance);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateUserBalance();
		}
	}
}
