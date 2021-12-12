package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import vendingmachine.VendingMachineController;

public class VendingMachine {

	private static VendingMachine vendingMachine = null;

	public int holdingMoney = 0;
	public int inputMoney = 0;
	public LinkedHashMap<Coin, Integer> holdingCoins;
	public ArrayList<Item> holdingItem = new ArrayList<Item>();

	public VendingMachine vendingMachine(){
		if (this.vendingMachine == null){
			VendingMachine vendingMachine = new VendingMachine();
		}
		return vendingMachine;
	}

	public LinkedHashMap<Coin, Integer> getCoins(){
		Coins coins = new Coins(holdingMoney);
		this.holdingCoins = coins.getCoins();
		return holdingCoins;
	}
}
