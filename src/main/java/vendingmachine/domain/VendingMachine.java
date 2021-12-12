package vendingmachine.domain;

import java.util.HashMap;

import vendingmachine.VendingMachineController;

public class VendingMachine {

	private static VendingMachine vendingMachine = null;

	public int holdingMoney = 0;
	public HashMap<Coin, Integer> holdingCoins;

	public VendingMachine vendingMachine(){
		if (this.vendingMachine == null){
			VendingMachineController vendingMachine = new VendingMachineController();
		}
		return vendingMachine;
	}

	public void getCoins(){
		Coins coins = new Coins(holdingMoney);
		this.holdingCoins = coins.getCoins();
	}
}
