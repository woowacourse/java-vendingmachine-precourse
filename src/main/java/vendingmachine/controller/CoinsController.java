package vendingmachine.controller;

import vendingmachine.domain.coins.Coins;
import vendingmachine.dto.VendingMachineBalanceDto;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinsController {
	public Coins generateCoins() {
		VendingMachineBalanceDto vendingMachineBalanceDto = InputView.inputVendingMachineBalance();
		try {
			return vendingMachineBalanceDto.toCoinsEntity();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return generateCoins();
		}
	}
}
