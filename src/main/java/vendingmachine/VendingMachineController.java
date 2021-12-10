package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public void setUpInitialVendingMachine() {
		InputView.printInitialMoneySettingMessage();
		ChangeSlot changeSlot = new ChangeSlot();
		requestInitialMoney(changeSlot);

		InputView.printInitialProductSettingMessage();
		ProductStorage productStorage = new ProductStorage();
		requestInitialProducts(productStorage);

		InputView.printInsertMoneyMessage();
		vendingMachine = new VendingMachine(changeSlot, productStorage);
	}

	private void requestInitialMoney(ChangeSlot changeSlot) {
		try {
			changeSlot.input(Console.readLine());
			OutputView.printVendingMachineOwnCoins(changeSlot.createRandomCoins());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialMoney(changeSlot);
		}
	}

	private void requestInitialProducts(ProductStorage productStorage) {
		try {
			productStorage.createProducts(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInitialProducts(productStorage);
		}
	}

	public void use() {
		requestInsertMoney();
		repeatRequestTrading();
		returnChangeCoins();
	}
	
	private void requestInsertMoney() {
		try {
			vendingMachine.insertMoney(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
			requestInsertMoney();
		}
	}

	private void repeatRequestTrading() {
		while (vendingMachine.isUsable()) {
			requestTrading();
		}
	}

	private void requestTrading() {
		try {
			OutputView.printRemainMoney(vendingMachine.calculateRemainMoney());
			InputView.printProductForBuyingMessage();
			vendingMachine.trade(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.showMessage(illegalArgumentException);
		}
	}

	private void returnChangeCoins() {
		OutputView.printRemainMoney(vendingMachine.calculateRemainMoney());
		OutputView.printChange(vendingMachine.returnChange());
	}
}
