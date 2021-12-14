package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private static VendingMachine vendingMachine = null;

	public static VendingMachine getVendingMachine(){
		if (vendingMachine == null){
			synchronized (VendingMachine.class) {
				vendingMachine = new VendingMachine();
			}
		}
		return vendingMachine;
	}

	public void operate() {
		getVendingMachine();
		initialSetting(vendingMachine);
		buy(vendingMachine);
		returnChange(vendingMachine);
	}

	public void initialSetting(VendingMachine vendingMachine) {
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();
		vendingMachine.holdingCoins = vendingMachine.makeCoins();
		OutputView.printHoldingCoins(vendingMachine.holdingCoins);
		vendingMachine.holdingItemList = InputView.holdingItemsInput();
	}

	public void buy(VendingMachine vendingMachine) {
		vendingMachine.inputMoney = InputView.inputMoneyInput();
		String buyItem;
		while (vendingMachine.isAvailableKeepBuyingAboutPrice() && vendingMachine.isAvailableKeepBuyingAboutStock()) {
			OutputView.printBalance(vendingMachine);
			buyItem = InputView.buyItemInput(vendingMachine.holdingItemList, vendingMachine.inputMoney);
			vendingMachine.stockDeduct(buyItem);
			vendingMachine.inputMoneyDeduct(buyItem);
		}
	}

	public void returnChange(VendingMachine vendingMachine) {
		vendingMachine.calculateChangeCoins();
		OutputView.printChangeCoins(vendingMachine.changeCoins);
	}
}
