package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class Coins {
	private HashMap<Coin, Integer> coins;

	public Coins() {
		this.coins = new HashMap<>();
	}

	private void addCoin(Coin coin,int count) {
		coins.put(coin, count);
	}

	public void makeCoins(int money) {
		int count500 = makeRandomCoin(money / 500);
		money -= count500 * 500;
		int count100 = makeRandomCoin(money / 100);
		money -= count100 * 100;
		int count50 = makeRandomCoin(money / 50);
		money -= count50 * 50;
		int count10 = money / 10;
		addCoin(Coin.COIN_500, count500);
		addCoin(Coin.COIN_100, count100);
		addCoin(Coin.COIN_50, count50);
		addCoin(Coin.COIN_10, count10);
	}

	public int makeRandomCoin(int maxValue) {
		List<Integer> list = makeRandomCondition(maxValue);
		int count = Randoms.pickNumberInList(list);
		return count;
	}

	public List<Integer> makeRandomCondition(int maxValue) {
		List<Integer> numberList = new ArrayList<>();
		for (int i = 0; i <= maxValue; i++) {
			numberList.add(i);
		}
		return numberList;
	}

	@Override
	public String toString() {
		return "Coins{" +
			"coins=" + coins +
			'}';
	}
}
