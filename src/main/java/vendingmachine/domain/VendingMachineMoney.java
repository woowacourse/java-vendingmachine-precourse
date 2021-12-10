package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachineMoney {
	private final Map<Coin, Integer> coins = new LinkedHashMap<Coin, Integer>() {{
		put(Coin.COIN_500, 0);
		put(Coin.COIN_100, 0);
		put(Coin.COIN_50, 0);
		put(Coin.COIN_10, 0);
	}};

	public void moneyToCoins(Integer money) {
		List<Integer> tmpCoins = Arrays.asList(COIN_500_NUM, COIN_100_NUM, COIN_50_NUM, COIN_10_NUM);
		while (money != 0) {
			int coinAmount = Randoms.pickNumberInList(tmpCoins);
			Coin coin = Coin.findByAmount(coinAmount);
			if (money - coinAmount >= 0) {
				money -= coinAmount;
				coins.put(coin, coins.get(coin) + 1);
			}
		}
	}

	public Map<Coin, Integer> getCoins() {
		return Collections.unmodifiableMap(coins);
	}
}
