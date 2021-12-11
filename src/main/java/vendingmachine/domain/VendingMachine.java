package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.VendingMachineController;
import vendingmachine.view.InputView;

public class VendingMachine {

	private static VendingMachine vendingMachine = null;

	public int holdingMoney = 0;

	public VendingMachine vendingMachine(){
		if (this.vendingMachine == null){
			VendingMachineController vendingMachine = new VendingMachineController();
		}
		return vendingMachine;
	}
}
