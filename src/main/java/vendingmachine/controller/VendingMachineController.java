package vendingmachine.controller;

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
		inputAmount(vendingMachine);

		OutputView.printInputAmount(vendingMachine.getAmount());
		OutputView.printBuyItem();
		String s = InputView.inputText();
		Validator.validateItemName(s);
		if(vendingMachine.haveAffordableItem()){
			// 잔돈 반환 기능
			return;
		}
		// 구매기능
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
