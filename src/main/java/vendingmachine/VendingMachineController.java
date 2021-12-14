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

	InputView inputView = new InputView();

	public void operate() {
		getVendingMachine();
		initialSetting(vendingMachine);
		buy(vendingMachine);
		returnChange(vendingMachine);
	}

	public void initialSetting(VendingMachine vendingMachine) {
		vendingMachine.holdingMoney = inputView.holdingMoneyInput();
		vendingMachine.holdingCoins = vendingMachine.makeCoins();
		OutputView.printHoldingCoins(vendingMachine.holdingCoins);
		vendingMachine.holdingItemList = inputView.holdingItemsInput();
	}

	public void buy(VendingMachine vendingMachine) {
		vendingMachine.inputMoney = inputView.inputMoneyInput();
		String buyItem;
		while (vendingMachine.isAvailableKeepBuyingAboutPrice() && vendingMachine.isAvailableKeepBuyingAboutStock()) {
			OutputView.printBalance(vendingMachine.inputMoney);
			buyItem = inputView.buyItemInput(vendingMachine.holdingItemList, vendingMachine.inputMoney);
			vendingMachine.stockDeduct(buyItem);
			vendingMachine.inputMoneyDeduct(buyItem);
		}
	}

	public void returnChange(VendingMachine vendingMachine) {
		vendingMachine.calculateChangeCoins();
		OutputView.printChangeCoins(vendingMachine.changeCoins);
	}
}
