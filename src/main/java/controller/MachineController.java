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
		if (!vendingMachine.isAllProductsSoldOut()) {
			System.out.println("상품남음");
		}
		if (vendingMachine.hasEnoughMoneyToBuyProduct()) {
			System.out.println("최저가보다 투입금액이 많음");
		} else {
			System.out.println("최저가보다 투입금액이 적음");
		}
	}
}
