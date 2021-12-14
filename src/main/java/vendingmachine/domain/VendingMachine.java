package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.view.InputView;

public class VendingMachine {

	public int holdingMoney;
	public int inputMoney;
	public List<Item> holdingItemList;
	public Map<Coin, Integer> holdingCoins;
	public Map<Coin, Integer> changeCoins;
	private Coins coins;

	public VendingMachine(){
		holdingMoney = inputView.holdingMoneyInput();
		inputMoney = inputView.inputMoneyInput();
		holdingItemList = inputView.holdingItemsInput();
		holdingCoins = makeInitialHoldingCoins();
	}

	InputView inputView = new InputView();

	public Map<Coin, Integer> makeInitialHoldingCoins() {
		coins = new Coins(holdingMoney);
		return coins.generateCoins(holdingMoney);
	}

	public void settingInputHoldingMoney(){
		holdingMoney = inputView.holdingMoneyInput();
	}

	public void settingHoldingCoins(){
		holdingCoins = makeInitialHoldingCoins();
	}

	public void settingHoldingItemList(){
		holdingItemList = inputView.holdingItemsInput();
	}

	public void settingInputMoney(){
		inputMoney = inputView.inputMoneyInput();
	}

	public void stockDeduct(String buyItem) {
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem)) {
				holdingItemList.get(i).setStock(holdingItemList.get(i).getStock() - 1);
			}
		}
	}

	public void inputMoneyDeduct(String buyItem) {
		for (int i = 0; i < this.holdingItemList.size(); i++) {
			if (this.holdingItemList.get(i).getName().equals(buyItem)) {
				this.inputMoney -= this.holdingItemList.get(i).getPrice();
			}
		}
	}

	public void calculateChangeCoins() {
		changeCoins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			int count = Math.min(holdingCoins.get(coin), inputMoney / coin.getAmount());
			changeCoins.put(coin, count);
			inputMoney -= coin.getAmount() * count;
		}
	}

	public boolean isAvailableKeepBuyingAboutPrice() {
		boolean isAvailableKeepBuyingAboutPrice = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getPrice() <= inputMoney) {
				isAvailableKeepBuyingAboutPrice = true;
			}
		}
		return isAvailableKeepBuyingAboutPrice;
	}

	public boolean isAvailableKeepBuyingAboutStock() {
		boolean isAvailableKeepBuyingAboutStock = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getStock() > 0) {
				isAvailableKeepBuyingAboutStock = true;
			}
		}
		return isAvailableKeepBuyingAboutStock;
	}
}