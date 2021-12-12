package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.Converter;
import vendingmachine.util.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = initVendingMachine();
		OutputView.printChanges(vendingMachine.getChanges());
		OutputView.printItemSettingMessage();
		initVendingMachineItem(vendingMachine);
	}

	private void initVendingMachineItem(VendingMachine vendingMachine) {
		try {
			String inputItemText = InputView.inputText();
			List<Item> items = Converter.toItems(inputItemText);
			System.out.println(items);
			vendingMachine.initItemList(items);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			initVendingMachineItem(vendingMachine);
		}
	}

	private VendingMachine initVendingMachine() {
		try {
			OutputView.printInitMessage();
			int initialMoney = InputView.inputMoney();
			Validator.validateInitialMoney(initialMoney);
			return new VendingMachine(initialMoney);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return initVendingMachine();
		}
	}
}
