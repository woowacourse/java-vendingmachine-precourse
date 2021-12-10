package vendingmachine.controller;

import vendingmachine.domain.coins.Coins;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.dto.CoinsOutputDto;
import vendingmachine.dto.VendingMachineBalanceDto;
import vendingmachine.service.CoinsService;
import vendingmachine.service.UserBalanceService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinsController {
	private final CoinsService coinsService = CoinsService.getInstance();
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateCoins() {
		VendingMachineBalanceDto vendingMachineBalanceDto = InputView.inputVendingMachineBalance();
		try {
			Coins coins = vendingMachineBalanceDto.toCoinsEntity();
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
