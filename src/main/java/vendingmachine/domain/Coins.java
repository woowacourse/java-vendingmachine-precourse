package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	public static final String COIN_UNIT = "개";
	private LinkedHashMap<Coin, Integer> coins;

	public void makeCoins(int money) {
		List<Integer> coinType = getCoinType();
		setCoinsMap();
		while (money != 0) {
			int randomCoin = Randoms.pickNumberInList(coinType);
			if (money - randomCoin >= 0) {
				money -= randomCoin;
				addCoin(randomCoin);
			}
		}
	}

	private void setCoinsMap() {
		coins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	private void putCoin(Coin coin, int count) {
		coins.put(coin, count);
	}

	private void addCoin(int money) {
		coins.put(Coin.valueOf(money), coins.get(Coin.valueOf(money)) + 1);
	}

	private List<Integer> getCoinType() {
		List<Integer> coinType = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinType.add(coin.getAmount());
		}
		return coinType;
	}

	public Coins calculateChange(int change) {
		Coins changes = new Coins();
		changes.initCoin();
		for (Coin coin : Coin.values()) {
			int maxCoin = countMaxCoin(change, coin);
			change -= maxCoin * coin.getAmount();
			if (maxCoin > 0) {
				changes.putCoin(coin,maxCoin);
			}
		}
		return changes;
	}

	private void initCoin() {
		coins = new LinkedHashMap<>();
	}

	private int countMaxCoin(int change, Coin coin) {
		return Math.min(change / coin.getAmount(), coins.get(coin));
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Coin coin : coins.keySet()) {
			stringBuilder.append(Coin.getKoreanValue(coin)).append(" - ").append(coins.get(coin)).append(COIN_UNIT);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
