package vendingmachine.controller;

import java.util.HashMap;

import vendingmachine.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final VendingMachineService vendingMachineService = new VendingMachineService();

	public VendingMachine getVendingMachine() {
		return vendingMachineService.getVendingMachine();
	}

	public void inputVendingMachineChange() {
		String change;
		do {
			change = InputView.inputVendingMachineChange();
		} while (!vendingMachineService.validateVendingMachineChange(change));

		vendingMachineService.inputChangeAmount(change);
	}

	public void generateCoins() {
		vendingMachineService.generateCoins();
	}

	public void returnChange(int userInputAmount) {
		if (userInputAmount == 0) {
			return;
		}
		HashMap<Integer, Integer> resultCoins = vendingMachineService.returnChange(userInputAmount);
		StringBuilder result = new StringBuilder();
		Coin.getAmountList().stream()
			.filter(resultCoins::containsKey)
			.forEach(amount -> result.append(String.format("%d원 - %d개\n", amount, resultCoins.get(amount))));
		OutputView.printReturnedCoins(result.toString());
	}
}
