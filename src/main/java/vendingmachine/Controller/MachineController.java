package vendingmachine.Controller;

import static vendingmachine.View.OutputView.printBreak;

import vendingmachine.Model.ChangesCoinGroup;
import vendingmachine.Model.VendingMachine;
import vendingmachine.View.OutputView;

public class MachineController {
	private final VendingMachine vendingMachine;

	public MachineController() {
		this.vendingMachine = new VendingMachine();
	}

	public void operate() {
		initiate();
		activate();
		giveChanges();
	}

	private void initiate() {
		vendingMachine.initCoins(InputController.getMachineMoney());
		printBreak();

		OutputView.printCoin(vendingMachine.getCoinMap());
		printBreak();

		vendingMachine.initBeverages(InputController.getBeverageGroup());
		printBreak();

		vendingMachine.initUserMoney(InputController.getUserMoney(vendingMachine.getMinPrice()));
		printBreak();
	}

	private void activate() {
		OutputView.printUserMoney(vendingMachine.getUserMoneyInt());
		String beverageNameInput = InputController.getBeverageName(vendingMachine);
		printBreak();

		vendingMachine.sell(beverageNameInput);
		if (!vendingMachine.isActivateEnd()) {
			activate();
		}
	}

	private void giveChanges() {
		OutputView.printUserMoney(vendingMachine.getUserMoneyInt());
		OutputView.printChange(new ChangesCoinGroup(vendingMachine).getNotEmptyIntegerMap());
	}
}
