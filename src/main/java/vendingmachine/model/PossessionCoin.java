package vendingmachine.model;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class PossessionCoin {

	Map<Coin, Integer> coins = new LinkedHashMap<>();

	public PossessionCoin() {
		coins.put(Coin.COIN_10, INITIAL_NUMBER);
		coins.put(Coin.COIN_50, INITIAL_NUMBER);
		coins.put(Coin.COIN_100, INITIAL_NUMBER);
		coins.put(Coin.COIN_500, INITIAL_NUMBER);
	}

	public void createRandomCoins(PossessionMoney money) {
		while (money.isBiggerThanMinimumCoin()) {
			int randomMoney = pickNumberInList(Coin.createCoinList());
			Coin randomCoin = Coin.getCoin(randomMoney);
			if (money.canMoneyIntoCoin(randomMoney)) {
				money.changeMoneyIntoCoin(randomMoney);
				coins.put(randomCoin, coins.get(randomCoin) + 1);
			}
		}
	}
}
