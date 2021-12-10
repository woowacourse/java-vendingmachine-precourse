package vendingmachine.controller;

import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;
import vendingmachine.dto.CoinsOutputDto;
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
			Coins coins = Coins.from(vendingMachineBalance);
			coinsService.initCoins(coins);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateCoins();
		}
	}

	public void printGeneratedCoins() {
		Coins coins = coinsService.getCurrentCoins();
		OutputView.printVendingMachineHoldingCoins(
			CoinsOutputDto.from(coins)
		);
	}

	public void printChange() {
		UserBalance userBalance = userBalanceService.getUserBalance();
		Coins change = coinsService.getChange(userBalance);
		OutputView.printChange(
			CoinsOutputDto.from(change)
		);
	}
}
