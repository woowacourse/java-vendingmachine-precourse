package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.VendingMachineModel;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.VendingMachineOutputView;

public class VendingMachineController {
	private final static VendingMachineController vendingMachineController = new VendingMachineController();
	private final VendingMachineOutputView vendingMachineOutputView;
	private final VendingMachineModel vendingMachineModel;
	private final InputValidator inputValidator;


	private VendingMachineController() {
		vendingMachineOutputView = VendingMachineOutputView.getVendingMachineOutputView();
		vendingMachineModel = VendingMachineModel.getVendingMachineModel();
		inputValidator = InputValidator.getInputValidator();
	}

	public static VendingMachineController getVendingMachineController(){
		return vendingMachineController;
	}

	public void run(){
		vendingMachineModel.generateCoins(getInitialAmount());
		vendingMachineOutputView.printVendingMachineInitialCoinsOutputMessage();
		vendingMachineOutputView.printVendingMachineInitialCoins(vendingMachineModel.getNumberOfCoins());
	}

	private int getInitialAmount() {
		String amount;
		do {
			vendingMachineOutputView.printAmountInputMessage();
			amount = Console.readLine();
		}
		while (!inputValidator.checkInitialAmountInputExceptions(amount));
		return Integer.parseInt(amount);
	}
}
