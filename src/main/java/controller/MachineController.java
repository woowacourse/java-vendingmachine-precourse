package controller;

import model.VendingMachine;
import view.InputDisplay;
import view.OutputDisplay;

public class MachineController {

	private MachineController() {
	}

	public static void operateMachine() {
		VendingMachine vendingMachine = new VendingMachine();

		putChangeIntoMachine(vendingMachine);
		prepareProductOnMachine(vendingMachine);
		putInsertedMoneyIntoMachine(vendingMachine);

		sellProductInMachine(vendingMachine);

		refundChangeInMachine(vendingMachine);
	}

	private static void putChangeIntoMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputChange();
		vendingMachine.makeCoinBox(InputController.inputChange());
		OutputDisplay.showAllCoinInCoinBox(vendingMachine.giveAllOfEachCoins());
	}

	private static void prepareProductOnMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputProducts();
		while (true) {
			try {
				vendingMachine.makeProductBox(InputController.inputProducts());
				return;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private static void putInsertedMoneyIntoMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputInsertedMoney();
		vendingMachine.makeInsertedMoneyBox(InputController.inputInsertedMoney());
	}

	private static void sellProductInMachine(VendingMachine vendingMachine) {
		while (!vendingMachine.isAllProductSoldOut() && vendingMachine.hasEnoughMoneyToBuyProduct()) {
			OutputDisplay.showNowInsertedMoney(vendingMachine.giveInsertedMoney());
			InputDisplay.askInputProductNameToBuy();
			try {
				vendingMachine.sellProduct(InputController.inputProductNameToBuy());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private static void refundChangeInMachine(VendingMachine vendingMachine) {
		OutputDisplay.showNowInsertedMoney(vendingMachine.giveInsertedMoney());
		OutputDisplay.showChangeAsCoins(vendingMachine.giveChangeCoins());
	}
}
