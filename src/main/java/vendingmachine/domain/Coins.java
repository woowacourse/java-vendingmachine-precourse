package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

import static vendingmachine.domain.Coin.*;

public class Coins {
	public final List<Integer> coinsValueList = Arrays.asList(500, 100, 50, 10);

	public int holdingMoney;

	private static Map<Coin, Integer> coins = new LinkedHashMap<>();

	public Coins(int holdingMoney) {
		this.holdingMoney = holdingMoney;
		coins = initializeCoins();
	}

	public Map<Coin, Integer> initializeCoins() {
		coins.put(COIN_500, 0);
		coins.put(COIN_100, 0);
		coins.put(COIN_50, 0);
		coins.put(COIN_10, 0);
		generateCoins(holdingMoney);
		return coins;
	}

	public void generateCoins(int holdingMoney) {
		while (holdingMoney != 0) {
			Coin coin = pickRandomCoinValue();
			if (holdingMoney >= coin.getAmount()) {
				holdingMoney -= coin.getAmount();
				coins.put(coin, coins.get(coin) + 1);
			}
		}
	}

	public Coin pickRandomCoinValue() {
		int amount = Randoms.pickNumberInList(coinsValueList);
		return Coin.valueOf(amount);
	}

	public static Map<Coin, Integer> getCoins() {
		return coins;
	}
}
