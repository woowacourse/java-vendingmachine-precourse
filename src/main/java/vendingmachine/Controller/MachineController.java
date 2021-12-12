package vendingmachine.Controller;

import static vendingmachine.View.OutputView.printBreak;

import vendingmachine.Model.ChangesCoinGroup;
import vendingmachine.Model.Converter;
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
		vendingMachine.initCoins(Converter.getInt(InputController.getMachineMoney()));
		printBreak();

		OutputView.printCoin(vendingMachine.getCoins().getMap());
		printBreak();

		vendingMachine.initBeverage(Converter.getBeverages(InputController.getBeverages()));
		printBreak();

		vendingMachine.initUserMoney(Converter.getInt(InputController.getUserMoney()));
		printBreak();
	}

	private void activate() {
		OutputView.printUserMoney(vendingMachine.getUserMoney().get());
		String beverageNameInput = InputController.getBeverageName(vendingMachine);
		printBreak();

		vendingMachine.sell(beverageNameInput);
		if (!vendingMachine.isActivateEnd()) {
			activate();
		}
	}

	private void giveChanges() {
		OutputView.printUserMoney(vendingMachine.getUserMoney().get());

		ChangesCoinGroup changesCoinGroup = new ChangesCoinGroup(vendingMachine);
		changesCoinGroup.setRepeat();
		OutputView.printChange(changesCoinGroup.getNotEmptyMap());
	}
}
