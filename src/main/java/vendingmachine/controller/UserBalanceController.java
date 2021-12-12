package vendingmachine.controller;

import vendingmachine.dto.UserBalanceDto;
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

		int userBalance = Integer.parseInt(input);
		UserBalanceDto userBalanceDto = UserBalanceDto.from(userBalance);
		userBalanceService.initUserBalance(userBalanceDto);

		OutputView.printCurrentUserBalance(userBalance);
	}
}
