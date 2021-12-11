package vendingmachine.domain;

import static vendingmachine.utils.Constant.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.Constant;

public class Coins {
	private LinkedHashMap<Coin, Integer> coins;

	public Coins() {
		this.coins = new LinkedHashMap<>();
	}

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

	private List<Integer> getCoinType() {
		List<Integer> coinType = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinType.add(coin.getAmount());
		}
		return coinType;
	}

	private void setCoinsMap() {
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

	public Coins calculateChange(int change) {
		Coins changes = new Coins();
		for (Coin coin : Coin.values()) {
			int maxCoin = Math.min(change / coin.getAmount(), coins.get(coin));
			;
			change -= maxCoin * coin.getAmount();
			if (maxCoin > 0) {
				changes.putCoin(coin, maxCoin);
			}
		}
		return changes;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Coin coin : coins.keySet()) {
			stringBuilder.append(coin.getAmount()+ WON).append(" - ").append(coins.get(coin)).append(COIN_UNIT);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
