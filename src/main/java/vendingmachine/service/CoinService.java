package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.Money;

public class CoinService {

	private final Map<Integer, Integer> possessionCoins = new LinkedHashMap<>();
	private final Map<Integer, Integer> changeCoins = new LinkedHashMap<>();

	public CoinService() {
		initCoinList(possessionCoins);
		initCoinList(changeCoins);
	}

	public void initCoinList(Map<Integer, Integer> coins) {
		coins.put(Coin.COIN_500.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_100.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_50.getAmount(), INITIAL_NUMBER);
		coins.put(Coin.COIN_10.getAmount(), INITIAL_NUMBER);
	}

	public Map<Integer, Integer> getPossessionCoins() {
		return possessionCoins;
	}

	public Map<Integer, Integer> getChangeCoins() {
		return changeCoins;
	}

	public void createRandomCoins(Money money) {
		while (money.isMoneyBiggerThanValue(MINIMUM_COIN_AMOUNT)) {
			int randomAmount = pickNumberInList(Coin.createCoinList());
			if (money.isMoneyBiggerThanValue(randomAmount)) {
				money.subtractMoney(randomAmount);
				possessionCoins.put(randomAmount, possessionCoins.get(randomAmount) + 1);
			}
		}
	}

	public void createGreedyCoin(int money) {
		for (int amount : Coin.createCoinList()) {
			changeCoins
				.put(amount, Math.min(changeCoins.get(amount) + money / amount,
					possessionCoins.get(amount)));
			money -= amount * changeCoins.get(amount);
		}
	}
}
