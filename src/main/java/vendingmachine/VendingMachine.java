package vendingmachine;

import vendingmachine.domain.Coin;
import vendingmachine.view.InputView;

public class VendingMachine {

	private static VendingMachine vendingmachine = null;

	private int holdingMoney = 0;

	public VendingMachine Vendingmachine(){
		if (this.vendingmachine == null){
			VendingMachine vendingmachine = new VendingMachine();
		}
		return vendingmachine;
	}

	public void turnOn() {
		VendingMachine vendingmachine = new VendingMachine();
		holdingMoney = InputView.holdingMoneyInput();
	}
}
