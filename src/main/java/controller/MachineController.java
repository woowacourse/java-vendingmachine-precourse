package controller;

import model.VendingMachine;
import view.InputDisplay;
import view.OutputDisplay;

public class MachineController {

	private MachineController() {
	}

	public static void turnOnMachine() {
		VendingMachine vendingMachine = new VendingMachine();
		InputDisplay.askInputVendingMachineChange();
		vendingMachine.makeVendingMachineCoinBox(InputController.inputVendingMachineChange());
		OutputDisplay.showEachCoinInCoinBox(vendingMachine.giveEachCoinPrice(), vendingMachine.giveEachCoinCount());
		InputDisplay.askInputVendingMachineProduct();
		vendingMachine.makeVendingMachineProducts(InputController.inputVendingMachineProducts());
		InputDisplay.askInputUserInsertMoney();
		vendingMachine.makeUserInsertMoneyBox(InputController.inputUserInsertMoney());
		OutputDisplay.showNowUserInsertMoney(vendingMachine.giveUserInsertMoney());
	}
}
