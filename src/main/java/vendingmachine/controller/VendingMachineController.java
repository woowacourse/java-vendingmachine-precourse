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
		initItemList(vendingMachine);
		initInputAmount(vendingMachine);
	}

	private void initInputAmount(VendingMachine vendingMachine) {
		try {
			OutputView.printInputAmount();
			vendingMachine.initInputAmount(InputView.inputMoney());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			initInputAmount(vendingMachine);
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
