package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	public static final String CURRENT_MACHINE_COIN = "자판기가 보유한 동전";
	private HashMap<Coin, Integer> coins;

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
		coins = new HashMap<>();
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n").append(CURRENT_MACHINE_COIN).append("\n");
		for (Coin coin : Coin.values()) {
			stringBuilder.append(Coin.getKoreanValue(coin)).append(" - ").append(coins.get(coin)).append("개");
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
