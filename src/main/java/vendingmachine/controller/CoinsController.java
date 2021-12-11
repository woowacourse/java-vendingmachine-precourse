package vendingmachine.controller;

import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;
import vendingmachine.dto.CoinsDto;
import vendingmachine.exception.NotNumericException;
import vendingmachine.service.CoinsService;
import vendingmachine.utils.StringUtils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinsController {
	private final CoinsService coinsService = new CoinsService();

	public void generateCoins() {
		String input = InputView.inputVendingMachineBalance();

		if (!StringUtils.isNumeric(input)) {
			throw new NotNumericException();
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
		CoinsDto coinsDto = coinsService.getChange();
		OutputView.printChange(coinsDto);
	}
}
