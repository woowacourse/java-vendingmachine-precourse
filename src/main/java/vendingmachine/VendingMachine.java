package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private int leftMoney;
	private HashMap<Coin, Integer> coins;
	private HashMap<String, Product> products;
	private int inputAmount;

	VendingMachine(){
		this.leftMoney = InputReceiver.getNumber();
		_makeCoins();
		this.products = InputReceiver.getProductInfo();
		this.inputAmount = InputReceiver.getNumber();
	}

	public void buy(String productName){
		Product buyingProduct = products.get(productName);
		buyingProduct.reduceQuantity();
		this.inputAmount -= buyingProduct.getPrice();
	}

	public boolean canBuyAnything(){
		for(Product temp : products.values()){
			if(temp.getQuantity() != 0 && temp.getPrice() < inputAmount){
				return true;
			}
		}
		return false;
	}

	public boolean isLeftQuantity(String productName){
		return products.get(productName).getQuantity() == 0;
	}

	public boolean isBuyableProduct(String productName){
		return products.get(productName).getPrice() > this.inputAmount;
	}

	private void _makeCoins(){
		for(Coin coin : Coin.values()){
			coins.put(coin, 0);
		}

		int amountOfCoins = 0;

		while(this.leftMoney != amountOfCoins){
			Coin key = Coin.getCoin(Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10)));
			int value = coins.get(key) + 1;
			coins.put(key, value);
			amountOfCoins += key.getAmount();
		}
	}
}
