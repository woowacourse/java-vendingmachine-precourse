package vendingmachine.controller;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;
import vendingmachine.dto.CoinsDto;
import vendingmachine.exception.NotNaturalNumberException;
import vendingmachine.service.CoinsService;
import vendingmachine.service.UserBalanceService;
import vendingmachine.utils.StringUtils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinsController {
	private final CoinsService coinsService = CoinsService.getInstance();
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateCoins() {
		String input = InputView.inputVendingMachineBalance();

		if (!StringUtils.isNumeric(input)) {
			throw new NotNaturalNumberException();
		}

		try {
			VendingMachineBalance vendingMachineBalance = VendingMachineBalance.from(Integer.parseInt(input));
			coinsService.generateRandomCoins(vendingMachineBalance);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateCoins();
		}
	}

	public void printGeneratedCoins() {
		CoinsDto coinsDto = coinsService.getCurrentCoins();
		OutputView.printVendingMachineHoldingCoins(coinsDto);
	}

	public void printChange() {
		UserBalance userBalance = userBalanceService.getUserBalance();
		CoinsDto coinsDto = coinsService.getChange(userBalance);
		OutputView.printChange(coinsDto);
	}
}
