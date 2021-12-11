package vendingmachine.model;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class PossessionCoin {

	Map<Integer, Integer> coins = new LinkedHashMap<>();

	public PossessionCoin() {
		coins.put(Coin.COIN_500.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_100.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_50.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_10.getAmount(), INITIAL_NUMBER);
	}

	public Map<Integer, Integer> getCoins() {
		return coins;
	}

	public void createRandomCoins(PossessionMoney money) {
		while (money.isBiggerThanMinimumCoin()) {
			int randomAmount = pickNumberInList(Coin.createCoinList());
			if (money.canMoneyIntoCoin(randomAmount)) {
				money.changeMoneyIntoCoin(randomAmount);
				coins.put(randomAmount, coins.get(randomAmount) + 1);
			}
		}
	}
}
