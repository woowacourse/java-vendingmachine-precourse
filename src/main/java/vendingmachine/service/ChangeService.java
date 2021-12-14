package vendingmachine.service;

import static vendingmachine.constants.Constant.NO_COIN_COUNT;

import java.util.EnumMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class ChangeService {
	public Map<Coin, Integer> returnChange(Map<Coin, Integer> vendingMachineCoins, int remainedMoney) {
		Map<Coin, Integer> change = new EnumMap<>(Coin.class);

		makeChange(vendingMachineCoins, change, remainedMoney);

		return change;
	}

	private void makeChange(Map<Coin, Integer> vendingMachineCoins, Map<Coin, Integer> change, int changeMoney) {
		for (Map.Entry<Coin, Integer> coin : vendingMachineCoins.entrySet()) {
			int coinAmount = coin.getKey().getAmount();
			int coinCount = coin.getValue();
			int neededCoinCount = changeMoney / coinAmount;

			if (canMakeChange(changeMoney, coinAmount, coinCount)) {
				changeMoney = getChangeMoney(change, changeMoney, coin, coinAmount, coinCount, neededCoinCount);
			}
		}
	}

	private int getChangeMoney(Map<Coin, Integer> change, int changeMoney, Map.Entry<Coin, Integer> coin,
								int coinAmount, int coinCount, int neededCoinCount) {
		if (neededCoinCount > coinCount) {
			change.put(coin.getKey(), coinCount);
			changeMoney = getRemainedChange(changeMoney, coinAmount, coinCount);
			return changeMoney;
		}

		change.put(coin.getKey(), neededCoinCount);
		changeMoney = getRemainedChange(changeMoney, coinAmount, neededCoinCount);
		return changeMoney;
	}

	private boolean canMakeChange(int changeMoney, int coinAmount, int coinCount) {
		return !hasNoCoins(coinCount) && isEnoughCoinAmount(changeMoney, coinAmount);
	}

	private boolean isEnoughCoinAmount(int changeMoney, int amount) {
		return changeMoney / amount > NO_COIN_COUNT;
	}

	private boolean hasNoCoins(int coinCount) {
		return coinCount == NO_COIN_COUNT;
	}

	private int getRemainedChange(int changeMoney, int coinAmount, int count) {
		return changeMoney - (coinAmount * count);
	}
}
