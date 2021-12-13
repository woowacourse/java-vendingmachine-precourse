package controller;

import model.VendingMachine;
import view.InputDisplay;
import view.OutputDisplay;

public class MachineController {

	private MachineController() {
	}

	public static void turnOnMachine() {
		VendingMachine vendingMachine = new VendingMachine();

		putChangeIntoMachine(vendingMachine);
		prepareProductOnMachine(vendingMachine);
		putInsertedMoneyIntoMachine(vendingMachine);

		sellProductInMachine(vendingMachine);
	}

	private static void putChangeIntoMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputChange();
		vendingMachine.makeCoinBox(InputController.inputChange());
		OutputDisplay.showCoinsInCoinBox(vendingMachine.givePriceOfEachCoins(), vendingMachine.giveCountOfEachCoins());
	}

	private static void prepareProductOnMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputProducts();
		vendingMachine.makeProductBox(InputController.inputProducts());
	}

	private static void putInsertedMoneyIntoMachine(VendingMachine vendingMachine) {
		InputDisplay.askInputInsertedMoney();
		vendingMachine.makeInsertedMoneyBox(InputController.inputInsertedMoney());
	}

	private static void sellProductInMachine(VendingMachine vendingMachine) {
		while (!vendingMachine.isAllProductSoldOut() && vendingMachine.hasEnoughMoneyToBuyProduct()) {
			OutputDisplay.showNowInsertedMoney(vendingMachine.giveInsertedMoney());
			InputDisplay.askInputProductToBuy();
			vendingMachine.sellProduct(InputController.inputProductNameToBuy());
		}
	}
}
