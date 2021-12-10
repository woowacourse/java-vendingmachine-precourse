package vendingmachine.controller;

import vendingmachine.domain.coins.Coins;
import vendingmachine.dto.CoinsOutputDto;
import vendingmachine.dto.VendingMachineBalanceDto;
import vendingmachine.service.CoinsService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinsController {
	private final CoinsService coinsService = CoinsService.getInstance();

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
}
