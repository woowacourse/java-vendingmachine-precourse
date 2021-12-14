package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static vendingmachine.constant.Constant.*;

import java.util.Map;

import vendingmachine.model.Coin;
import vendingmachine.model.Coins;
import vendingmachine.model.Money;

public class CoinService {

	Coins possessionCoins;
	Coins changeCoins;

	public CoinService() {
		possessionCoins = new Coins();
		changeCoins = new Coins();
	}

	public void createRandomCoins(Money money) {
		while (money.isMoneyBiggerThanValue(MINIMUM_COIN_AMOUNT)) {
			int randomAmount = pickNumberInList(Coin.createCoinList());
			if (money.isMoneyBiggerThanValue(randomAmount)) {
				money.subtractMoney(randomAmount);
				possessionCoins.getCoins().put(randomAmount, possessionCoins.getCoins().get(randomAmount) + 1);
			}
		}
	}

	public Map<Integer, Integer> getPossessionCoins() {
		return possessionCoins.getCoins();
	}

	public Map<Integer, Integer> getChangeCoins() {
		return changeCoins.getCoins();
	}

	public void createGreedyCoin(int money) {
		for (int amount : Coin.createCoinList()) {
			changeCoins.getCoins()
				.put(amount, Math.min(changeCoins.getCoins().get(amount) + money / amount,
					possessionCoins.getCoins().get(amount)));
			money -= amount * changeCoins.getCoins().get(amount);
		}
	}

}
