package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	public void Operate(){
		VendingMachine vendingMachine = new VendingMachine();
		initialSetting(vendingMachine);
		run(vendingMachine);
	}

	public void initialSetting(VendingMachine vendingMachine) {
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();
		vendingMachine.holdingCoins = vendingMachine.getCoins();
		OutputView.printHoldingCoins(vendingMachine.holdingCoins);
	}

	public void run(VendingMachine vendingMachine){
		vendingMachine.holdingItem = InputView.holdingItemsInput();
		vendingMachine.inputMoney = InputView.inputMoneyInput();
		buy(vendingMachine);
	}

	public void buy(VendingMachine vendingMachine){
		String buyItem = InputView.buyItemInput();
		vendingMachine.stockDeduct(buyItem);
		vendingMachine.inputMoneyDeduct(buyItem);
		OutputView.printBalance(vendingMachine.getInputMoney());
	}


}
