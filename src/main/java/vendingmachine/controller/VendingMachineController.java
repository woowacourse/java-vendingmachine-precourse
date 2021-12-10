package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.ItemModel;
import vendingmachine.model.CoinModel;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineOutputView vendingMachineOutputView;
	private final CoinModel coinModel;
	private final InputValidator inputValidator;
	private final ItemModel itemModel;

	private VendingMachineController() {
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		coinModel = CoinModel.getCoinModel();
		inputValidator = InputValidator.getInputValidator();
		itemModel = ItemModel.getItemModel();
	}

	public static VendingMachineController getVendingMachineController() {
		return vendingMachineController;
	}

	public void run() {
		coinModel.generateCoins(getInitialAmount());
		vendingMachineOutputView.printVendingMachineInitialCoinsOutputMessage();
		vendingMachineOutputView.printVendingMachineInitialCoins(coinModel.getNumberOfCoins());
		itemModel.createItems(getInitialItems());
	}

	private int getInitialAmount() {
		String amount;
		do {
			vendingMachineOutputView.printAmountInputMessage();
			amount = Console.readLine();
		} while (!inputValidator.checkInitialAmountInputExceptions(amount));
		return Integer.parseInt(amount);
	}

	private List<String> getInitialItems() {
		String items;
		do {
			vendingMachineOutputView.printInitialItemsInputMessage();
			items = Console.readLine();
		} while (!inputValidator.checkInitialItemsInputExceptions(items));
		return parseItemStringIntoItemList(items);
	}

	private List<String> parseItemStringIntoItemList(String items) {
		return Arrays.stream(items.split(";"))
			.map(item -> item.substring(1, item.length() - 1))
			.map(itemElement -> itemElement.split(","))
			.flatMap(Arrays::stream)
			.collect(Collectors.toList());
	}
}
