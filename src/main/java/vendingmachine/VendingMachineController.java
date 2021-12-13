package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final VendingMachine vendingMachine = new VendingMachine();

	public void Operate() {
		initialSetting(vendingMachine);
		run(vendingMachine);
		buy(vendingMachine);
		returnChange(vendingMachine);
	}

	public void initialSetting(VendingMachine vendingMachine) {
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();
		vendingMachine.holdingCoins = vendingMachine.makeCoins();
		OutputView.printHoldingCoins(vendingMachine.holdingCoins);
	}

	public void run(VendingMachine vendingMachine) {
		vendingMachine.holdingItemList = InputView.holdingItemsInput();
		vendingMachine.inputMoney = InputView.inputMoneyInput();
	}

	public void buy(VendingMachine vendingMachine) {
		String buyItem;
		while (vendingMachine.isAvailableKeepBuyingAboutPrice() && vendingMachine.isAvailableKeepBuyingAboutStock()) {
			OutputView.printBalance(vendingMachine);
			do {
				buyItem = InputView.buyItemInput();
			} while (!vendingMachine.isPurchasableItem(buyItem));
			vendingMachine.stockDeduct(buyItem);
			vendingMachine.inputMoneyDeduct(buyItem);
		}
	}

	public void returnChange(VendingMachine vendingMachine) {
		vendingMachine.calculateChangeCoins();
		OutputView.printChangeCoins(vendingMachine.changeCoins);
	}
}
