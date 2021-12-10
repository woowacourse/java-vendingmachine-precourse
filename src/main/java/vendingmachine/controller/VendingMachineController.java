package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.ItemModel;
import vendingmachine.model.CoinModel;
import vendingmachine.model.VendingMachineModel;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineOutputView vendingMachineOutputView;
	private final InputValidator inputValidator;
	private VendingMachineModel vendingMachineModel;

	private VendingMachineController() {
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		inputValidator = InputValidator.getInputValidator();
		vendingMachineModel = VendingMachineModel.getVendingMachineModel();
	}

	public static VendingMachineController getVendingMachineController() {
		return vendingMachineController;
	}

	public void run() {
		vendingMachineModel.generateCoins(getInitialAmount());
		vendingMachineOutputView.printVendingMachineInitialCoinsOutputMessage();
		vendingMachineOutputView.printVendingMachineInitialCoins(vendingMachineModel.getNumberOfCoins());
		vendingMachineModel.createItems(getInitialItems());
		vendingMachineModel.putMoney(getInputAmount());
	}

	private String getInitialAmount() {
		String amount;
		do {
			vendingMachineOutputView.printAmountInputMessage();
			amount = Console.readLine();
		} while (!inputValidator.checkInitialAmountInputExceptions(amount));
		return amount;
	}

	private String getInitialItems() {
		String items;
		do {
			vendingMachineOutputView.printInitialItemsInputMessage();
			items = Console.readLine();
		} while (!inputValidator.checkInitialItemsInputExceptions(items));
		return items;
	}

	private String getInputAmount() {
		String inputAmount;
		do {
			vendingMachineOutputView.printUserInputAmountMessage();
			inputAmount = Console.readLine();
		} while (!inputValidator.checkInputAmountInputExceptions(inputAmount));
		return inputAmount;
	}
}
