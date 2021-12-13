package vendingmachine.controller;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.service.MachineService;
import vendingmachine.util.parser.ItemParser;
import vendingmachine.util.parser.Parser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
	MachineService machineService = new MachineService();

	public void run() {
		Long machineId = machineService.generate();
		inputCoinsToMachineByManager(machineId);
		inputItemsToMachineByManager(machineId);
		inputCoinsToMachineByUser(machineId);
		purchaseItemsByUser(machineId);
		printRestCoinsAndExit(machineId);
	}

	private void printRestCoinsAndExit(Long machineId) {
		OutputView.printInputCoins(machineService.getInputCoinAmount(machineId));
		OutputView.printHeadLast();
		OutputView.printMachineCoins(machineService.returnCoins(machineId));
	}

	private void purchaseItemsByUser(Long machineId) {
		while (machineService.isPurchasable(machineId)) {
			OutputView.printInputCoins(machineService.getInputCoinAmount(machineId));
			InputView.requestPurchaseItem();
			try {
				machineService.purchase(machineId, Console.readLine());
			} catch (IllegalArgumentException e) {
				OutputView.printExceptionMessage(e.getMessage());
			}
		}
	}

	private void inputCoinsToMachineByUser(Long machineId) {
		InputView.requestInputCoins();
		machineService.addInputCoins(machineId, getInputCoinsByUser());
	}

	private void inputItemsToMachineByManager(Long machineId) {
		InputView.requestItems();
		machineService.addItems(machineId, getItemsByManager());
	}

	private void inputCoinsToMachineByManager(Long machineId) {
		InputView.requestMachineCoinsAmount();
		machineService.addCoins(machineId, getCoinAmountByUser());
		OutputView.printHeadFirst();
		OutputView.printMachineCoins(machineService.getCoins(machineId));
	}

	private Integer getInputCoinsByUser() {
		try {
			return Parser.convertStringToInt(Console.readLine());
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getInputCoinsByUser();
		}
	}

	private Map<String, Item> getItemsByManager() {
		try {
			return ItemParser.getItems(Console.readLine());
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return getItemsByManager();
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
