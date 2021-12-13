package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.service.MachineService;
import vendingmachine.util.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	MachineService machineService = new MachineService();

	public void run() {
		InputView.requestMachineCoinsAmount();
		Long id = machineService.generate();
		int coinAmount = getCoinAmountByUser();
		machineService.addInputCoins(id, coinAmount);
	}

	private int getCoinAmountByUser() {
		try {
			return Parser.convertStringToInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getCoinAmountByUser();
		}
	}
}
