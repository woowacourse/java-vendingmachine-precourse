package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import vendingmachine.Coin;

public class VendingMachine {

	private Map<Integer,Integer> coinMap;
	private List<Product> products;

	public VendingMachine() {
		this.coinMap = new TreeMap<>(Collections.reverseOrder());
		coinMap.put(Coin.COIN_500.getAmount(), 0);
		coinMap.put(Coin.COIN_100.getAmount(), 0);
		coinMap.put(Coin.COIN_50.getAmount(), 0);
		coinMap.put(Coin.COIN_10.getAmount(), 0);
	}

	public void addCoin(int coin){
		coinMap.put(coin,coinMap.get(coin)+1);
	}

	public void addProduct(Product product){
		products.add(product);
	}

	public Map<Integer, Integer> getCoinMap() {
		return coinMap;
	}
}
