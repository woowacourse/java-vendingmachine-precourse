package vendingmachine.util;

import vendingmachine.model.Coin;
import vendingmachine.model.CoinStock;

import java.util.*;

public class CoinCalculator {
	public List<CoinStock> combineCoinsByGreedy(List<CoinStock> coins, int remainMoney) {
		List<CoinStock> returnCoins = new ArrayList<>();
		for (CoinStock coinStock : coins) {
			int count = getMaxCoinCount(coinStock, remainMoney);
			CoinStock returnCoin = new CoinStock(coinStock.getAmount(), count);
			returnCoins.add(returnCoin);
			remainMoney -= returnCoin.getTotal();
		}
		return returnCoins;
	}

	private int getMaxCoinCount(CoinStock coinStock, int money) {
		int max = 0;
		for (int i = 0; i <= coinStock.getStock(); i++) {
			if (coinStock.getAmount() * i <= money) {
				max = i;
			}
		}
		return max;
	}
}
