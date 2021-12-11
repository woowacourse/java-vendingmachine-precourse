package vendingmachine.controller;

import vendingmachine.model.receiver.MoneyReceiver;
import vendingmachine.model.service.CoinService;
import vendingmachine.view.VendingMachineView;

public class VendingMachineController {

	VendingMachineView vendingMachineView = new VendingMachineView();
	MoneyReceiver moneyReceiver = new MoneyReceiver();
	CoinService coinService = new CoinService();

	public void run() {
		inputMoneyForChange();

		showCoinInVendingMachine();

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
		coinService.fillCoin(change);

		vendingMachineView.makeEmptyLine();
	}

	private void showCoinInVendingMachine() {
		vendingMachineView.showCoinsInVendingMachine();
		vendingMachineView.makeEmptyLine();
	}
}
