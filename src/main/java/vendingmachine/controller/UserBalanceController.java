package vendingmachine.controller;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.exception.NotNumericException;
import vendingmachine.service.UserBalanceService;
import vendingmachine.utils.StringUtils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class UserBalanceController {
	private final UserBalanceService userBalanceService = new UserBalanceService();

	public void generateUserBalance() {
		String input = InputView.inputUserBalance();

		try {
			initUserBalance(input);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateUserBalance();
		}
	}

	private void initUserBalance(String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new NotNumericException();
		}

		UserBalance userBalance = UserBalance.from(Integer.parseInt(input));
		userBalanceService.initUserBalance(userBalance);
		OutputView.printCurrentUserBalance(userBalance.toInt());
	}
}
