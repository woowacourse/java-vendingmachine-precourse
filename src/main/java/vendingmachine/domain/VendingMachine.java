package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class VendingMachine {

	private static VendingMachine vendingMachine = null;

	Coins coins;

	public int holdingMoney = 0;
	public int inputMoney = 0;
	public LinkedHashMap<Coin, Integer> holdingCoins;
	public LinkedHashMap<Coin, Integer> changeCoins;
	public ArrayList<Item> holdingItem;

	public VendingMachine vendingMachine() {
		if (this.vendingMachine == null) {
			VendingMachine vendingMachine = new VendingMachine();
		}
		return vendingMachine;
	}

	public LinkedHashMap<Coin, Integer> makeCoins() {
		coins = new Coins(holdingMoney);
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

	public void inputMoneyDeduct(String buyItem) {
		for (int i = 0; i < this.holdingItem.size(); i++) {
			if (this.holdingItem.get(i).getName().equals(buyItem)) {
				this.inputMoney -= this.holdingItem.get(i).getPrice();
			}
		}
	}

	public boolean isAvailableKeepBuyingAboutPrice(){
		boolean isAvailableKeepBuyingAboutPrice = false;
		for (int i = 0; i < holdingItem.size(); i++){
			if (holdingItem.get(i).getPrice() <= inputMoney){
				isAvailableKeepBuyingAboutPrice = true;
			}
		}
		return isAvailableKeepBuyingAboutPrice;
	}

	public boolean isAvailableKeepBuyingAboutStock() {
		boolean isAvailableKeepBuyingAboutStock = false;
		for(int i = 0; i< holdingItem.size(); i++){
			if(holdingItem.get(i).getStock() > 0){
				isAvailableKeepBuyingAboutStock = true;
			}
		}
		return isAvailableKeepBuyingAboutStock;
	}

	public void calculateChangeCoins() {
		Changes changes = new Changes();
		this.changeCoins = changes.returnChange(holdingCoins, inputMoney);
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public LinkedHashMap<Coin, Integer> getCoins() {
		return holdingCoins;
	}
}
