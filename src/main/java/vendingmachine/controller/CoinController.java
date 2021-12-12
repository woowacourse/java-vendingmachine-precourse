package vendingmachine.controller;

import java.util.Map;

import vendingmachine.domain.coin.CoinCounter;
import vendingmachine.domain.coin.CoinService;
import vendingmachine.validator.AmountValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class CoinController {
	private CoinService coinService;
	private CoinCounter coinCounter;

	public CoinController() {
		coinService = new CoinService();
	}

	public void setVendingMachineCoinCounter() {
		int amount = getVendingMachineAmount();
		Map<Integer, Integer> coinCounter = coinService.getCoinCounter(amount);
		this.coinCounter = new CoinCounter(coinCounter);
		OutputView.printCoinCounter(this.coinCounter);
	}

	private int getVendingMachineAmount() {
		try {
			String amount = InputView.getVendingMachineAmount();
			AmountValidator.checkVendingMachineAmount(amount);
			return Integer.parseInt(amount);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getVendingMachineAmount();
		}
	}
}
