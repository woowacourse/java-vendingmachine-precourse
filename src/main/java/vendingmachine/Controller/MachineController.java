package vendingmachine.Controller;

import static vendingmachine.View.OutputView.printBreak;

import vendingmachine.Controller.Run.Activator;
import vendingmachine.Controller.Run.Changes;
import vendingmachine.Model.Converter;
import vendingmachine.Model.VendingMachine;
import vendingmachine.View.OutputView;

public class MachineController {
	public VendingMachine vendingMachine;

	public MachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void operate() {
		init();
		activate();
		giveChanges();
	}

	public void init() {
		vendingMachine.initCoins(Converter.convertToInt(InputController.getMachineMoneyInput()));
		printBreak();

		OutputView.printCoin(vendingMachine.machineCoins.coins);
		printBreak();

		vendingMachine.initProduct(Converter.convertToProducts(InputController.getProductsInput()));
		printBreak();

		vendingMachine.initUserMoney(Converter.convertToInt(InputController.getUserMoneyInput()));
		printBreak();
	}

	public void activate() {
		OutputView.printUserMoney(vendingMachine.userMoney);
		String productNameInput = InputController.getProductNameInput(vendingMachine);
		printBreak();

		Activator activator = new Activator(vendingMachine);
		activator.sell(vendingMachine.products.getProduct(productNameInput));
		if (!activator.isActivateEnd()) {
			activate();
		}
	}

	public void giveChanges() {
		OutputView.printUserMoney(vendingMachine.userMoney);

		Changes changes = new Changes(vendingMachine);
		changes.setChangeCoins();
		OutputView.printChange(changes.getChangeCoins().getNotEmptyCoins());
	}
}
