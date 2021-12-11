package vendingmachine.controller;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.domain.Change;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {

	private VendingMachine vendingMachine;

	public void run() {
		setting();
		progress();
		finishWithReturn();
	}

	private void setting() {
		Change changes = Change.generateChanges(InputView.getHavingMoney());
		OutputView.printHavingMachineCoin(changes);
		Beverages beverages = InputView.getItemPriceStock();
		Money inputMoney = InputView.getUserInputMoney();
		vendingMachine = new VendingMachine(beverages, changes, inputMoney);
	}

	private void progress() {
		while (vendingMachine.canSell()) {
			OutputView.printInputMoney(vendingMachine.getMoney());
			String itemName = InputView.getItemName();
			Beverage beverage = vendingMachine.findBeverageByName(itemName);
			vendingMachine.sell(beverage);
		}
	}

	private void finishWithReturn() {
		Change calculatedChange = vendingMachine.returnChange();
		OutputView.printInputMoney(vendingMachine.getMoney());
		OutputView.printExtraMoneyAndChange(calculatedChange);
	}

}
