package vendingmachine.model;

import static vendingmachine.util.RandomNumberGenerator.*;

import java.util.LinkedHashMap;

// TODO: 2021/12/08 더 좋은 이름
public class CoinList {

	private final LinkedHashMap<Coin, Integer> hashMap;
	private final int totalMoney;

	public CoinList(int totalMoney) {
		this.totalMoney = totalMoney;
		this.hashMap = new LinkedHashMap<>();
		hashMap.put(Coin.COIN_500, 0);
		hashMap.put(Coin.COIN_100, 0);
		hashMap.put(Coin.COIN_50, 0);
		hashMap.put(Coin.COIN_10, 0);
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public LinkedHashMap<Coin, Integer> getHashMap() {
		return hashMap;
	}

	public void init() {
		int leftMoney = totalMoney;
		leftMoney -= addCoinsAndReturnAddedAmount(leftMoney, Coin.COIN_500);
		leftMoney -= addCoinsAndReturnAddedAmount(leftMoney, Coin.COIN_100);
		leftMoney -= addCoinsAndReturnAddedAmount(leftMoney, Coin.COIN_50);
		hashMap.put(Coin.COIN_10, leftMoney / Coin.COIN_10.getAmount());
		System.out.println(this);
	}

	private int addCoinsAndReturnAddedAmount(int money, Coin coin) {
		if (money < coin.getAmount()) {
			return 0;
		}

		int maxNumberOfCoins = money / coin.getAmount();
		int numberOfCoins = generateNumberOfCoins(maxNumberOfCoins);
		hashMap.put(coin, numberOfCoins);

		return coin.getAmount() * numberOfCoins;
	}

	public void subtractCoin(Coin coin, int remainingCoins) {
		hashMap.replace(coin, remainingCoins);
	}

	public String toString() {
		return "\n자판기가 보유한 동전\n" +
			Coin.COIN_500.getAmount() + "원 - " + hashMap.get(Coin.COIN_500) + "개\n" +
			Coin.COIN_100.getAmount() + "원 - " + hashMap.get(Coin.COIN_100) + "개\n" +
			Coin.COIN_50.getAmount() + "원 - " + hashMap.get(Coin.COIN_50) + "개\n" +
			Coin.COIN_10.getAmount() + "원 - " + hashMap.get(Coin.COIN_10) + "개\n";
	}

}
