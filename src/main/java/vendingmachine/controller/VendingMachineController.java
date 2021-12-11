package vendingmachine.controller;

import vendingmachine.model.receiver.MoneyReceiver;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {

	VendingMachineView vendingMachineView = new VendingMachineView();
	MoneyReceiver moneyReceiver = new MoneyReceiver();

	public void run() {
		inputMoneyForChange();

		// showCoinInVendingMachine();
		//
		// inputProductInfo();
		//
		// Customer customer = inputMoneyForBuy();
		//
		// int restMoney = buyProduct(customer);
		//
		// giveChange(restMoney);
	}

	private void inputMoneyForChange() {
		vendingMachineView.inputMoneyForChange();

		int change = moneyReceiver.receive();
		// coinService.fillCoin(change);

		vendingMachineView.makeEmptyLine();
	}
}
