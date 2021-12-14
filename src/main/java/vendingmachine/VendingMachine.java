package vendingmachine;

import java.util.Arrays;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private int leftMoney;
	private HashMap<Coin, Integer> coins;
	private HashMap<String, Product> products;

	VendingMachine(){
		this.leftMoney = InputReceiver.getNumber();
		_makeCoins();
		this.products = InputReceiver.getProductInfo();
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
