package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void use() {
		InputView.printInsertMoneyMessage();
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
