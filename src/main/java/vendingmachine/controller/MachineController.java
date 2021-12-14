package vendingmachine.controller;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.domain.Change;
import vendingmachine.domain.Money;
import vendingmachine.service.VendingMachine;
import vendingmachine.exception.InputException;
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
		Change changes = new Change();
		changes.generateChanges(InputView.getHavingMoney());
		OutputView.printHavingMachineCoin(changes);
		Beverages beverages = InputView.getItemPriceStock();
		Money inputMoney = InputView.getUserInputMoney();
		vendingMachine = new VendingMachine(beverages, changes, inputMoney);
	}

	private void progress() {
		while (vendingMachine.canSell()) {
			OutputView.printInputMoney(vendingMachine.getMoney());
			try {
				Beverage beverage = vendingMachine.findBeverageByName(InputView.getItemName());
				validationCanBuy(beverage);
				vendingMachine.sell(beverage);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void validationCanBuy(Beverage beverage) {
		if (vendingMachine.canNotSellOne(beverage)) {
			InputException.printNotEnoughMoney();
		}
	}

	private void finishWithReturn() {
		Change calculatedChange = vendingMachine.returnChange();
		OutputView.printInputMoney(vendingMachine.getMoney());
		OutputView.printExtraMoneyAndChange(calculatedChange);
	}

}
