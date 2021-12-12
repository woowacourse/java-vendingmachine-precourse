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
	public ArrayList<Item> holdingItem;

	public VendingMachine vendingMachine() {
		if (this.vendingMachine == null) {
			VendingMachine vendingMachine = new VendingMachine();
		}
		return vendingMachine;
	}

	public LinkedHashMap<Coin, Integer> getCoins() {
		Coins coins = new Coins(holdingMoney);
		this.holdingCoins = coins.getCoins();
		return holdingCoins;
	}

	public void stockDeduct(String buyItem) {
		for (int i = 0; i < holdingItem.size(); i++) {
			if (holdingItem.get(i).getName().equals(buyItem)) {
				holdingItem.get(i).setStock(holdingItem.get(i).getStock() - 1);
			}
		}
	}

	public void inputMoneyDeduct(String buyItem){
		for (int i = 0; i < this.holdingItem.size(); i++) {
			if (this.holdingItem.get(i).getName().equals(buyItem)) {
				this.inputMoney -= this.holdingItem.get(i).getPrice();
			}
		}
	}

	public int getInputMoney() {
		return inputMoney;
	}
}
