package vendingmachine;

import java.util.HashMap;

// TODO: 2021/12/08 더 좋은 이름
public class CoinList {

	private final HashMap<Coin, Integer> hashMap;
	private final int totalMoney;

	public CoinList(int totalMoney) {
		this.totalMoney = totalMoney;
		this.hashMap = new HashMap<>();
		hashMap.put(Coin.COIN_500, 0);
		hashMap.put(Coin.COIN_100, 0);
		hashMap.put(Coin.COIN_50, 0);
		hashMap.put(Coin.COIN_10, 0);
	}

	public String toString() {
		return "자판기가 보유한 동전\n" +
			Coin.COIN_500.getAmount() + "원 - " + hashMap.get(Coin.COIN_500) + "원\n" +
			Coin.COIN_100.getAmount() + "원 - " + hashMap.get(Coin.COIN_100) + "원\n" +
			Coin.COIN_50.getAmount() + "원 - " + hashMap.get(Coin.COIN_50) + "원\n" +
			Coin.COIN_10.getAmount() + "원 - " + hashMap.get(Coin.COIN_10) + "원\n";
	}

}
