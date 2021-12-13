package vendingmachine.controller;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.service.MachineService;
import vendingmachine.util.ItemParser;
import vendingmachine.util.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	MachineService machineService = new MachineService();

	public void run() {
		Long machineId = machineService.generate();

		InputView.requestMachineCoinsAmount();
		machineService.addInputCoins(machineId, getCoinAmountByUser());

		InputView.requestInputCoins();
		machineService.addInputCoins(machineId, getInputCoinsByUser());

		InputView.requestItems();
		machineService.addItems(machineId, getItemsByUser());
	}

	private Integer getInputCoinsByUser() {
		try {
			return Parser.convertStringToInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getInputCoinsByUser();
		}
	}

	private Map<String, Item> getItemsByUser() {
		try {
			return ItemParser.getItems(Console.readLine());
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getItemsByUser();
		}
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
