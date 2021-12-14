package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Converter;
import vendingmachine.util.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = initVendingMachine();
		OutputView.printMachineHavingChanges(vendingMachine.getChanges());
		initItemList(vendingMachine);
		inputAmount(vendingMachine);
		OutputView.printInputAmount(vendingMachine.getAmount());
		runVendingMachine(vendingMachine);
	}

	private void runVendingMachine(VendingMachine vendingMachine) {
		if (!vendingMachine.haveAffordableItem()) {
			OutputView.printReturnChanges(vendingMachine.returnChange());
			return;
		}
		buyItem(vendingMachine);
		runVendingMachine(vendingMachine);
	}

	private void buyItem(VendingMachine vendingMachine) {
		try {
			OutputView.printBuyItem();
			String wantedItemName = InputView.inputText();
			Validator.validateItemName(wantedItemName);
			vendingMachine.buy(wantedItemName);
			OutputView.printInputAmount(vendingMachine.getAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
	}

	private void inputAmount(VendingMachine vendingMachine) {
		try {
			OutputView.printEnterInputAmount();
			vendingMachine.inputAmount(InputView.inputMoney());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			inputAmount(vendingMachine);
		}
	}

	private void initItemList(VendingMachine vendingMachine) {
		try {
			OutputView.printItemSettingMessage();
			vendingMachine.initItemList(Converter.toItems(InputView.inputText()));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			initItemList(vendingMachine);
		}
	}

	private VendingMachine initVendingMachine() {
		try {
			OutputView.printInitMessage();
			int initialMoney = InputView.inputMoney();
			Validator.validateMoney(initialMoney);
			return new VendingMachine(initialMoney);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initVendingMachine();
		}
	}
}
