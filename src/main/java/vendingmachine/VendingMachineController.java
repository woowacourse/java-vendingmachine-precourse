package vendingmachine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {


	public void turnOn() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.holdingMoney = InputView.holdingMoneyInput();
		vendingMachine.holdingCoins = vendingMachine.getCoins();
		OutputView.printHoldingCoins(vendingMachine.holdingCoins);
		vendingMachine.holdingItem = InputView.holdingItemsInput();
	}

	public void Operate(){

	}


}
