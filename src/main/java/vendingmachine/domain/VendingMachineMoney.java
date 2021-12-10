package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.Collections;
import java.util.LinkedHashMap;
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
		while (money != 0) {
			int coinAmount = Randoms.pickNumberInList(COIN_VALUES);
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

	public Map<Coin, Integer> getChanges(int money) {
		Map<Coin, Integer> changes = new LinkedHashMap<>();
		for (Integer changeAmount : COIN_VALUES) {
			Coin coin = Coin.findByAmount(changeAmount);
			int changeCount = Math.min(money / changeAmount, coins.get(coin));
			if (changeCount != 0) {
				changes.put(Coin.findByAmount(changeAmount), changeCount);
				money -= changeCount * changeAmount;
				coins.put(coin, coins.get(coin) - changeCount);
			}
		}
		return changes;
	}
}
