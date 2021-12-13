package vendingmachine.service;

import java.util.EnumMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class ChangeService {
	public Map<Coin, Integer> returnChange(Map<Coin, Integer> vendingMachineCoins, int remainedMoney) {
		Map<Coin, Integer> change = new EnumMap<>(Coin.class);

		getChange(vendingMachineCoins, change, remainedMoney);

		return change;
	}

	private void getChange(Map<Coin, Integer> vendingMachineCoins, Map<Coin, Integer> change, int changeMoney) {
		for (Map.Entry<Coin, Integer> coin : vendingMachineCoins.entrySet()) {
			int coinAmount = coin.getKey().getAmount();
			int coinCount = coin.getValue();
			if (coinCount == 0 || changeMoney / coinAmount == 0) {
				continue;
			} else if (changeMoney / coinAmount > coinCount) {
				change.put(coin.getKey(), coinCount);
				changeMoney = changeMoney - (coinAmount * coinCount);
				continue;
			}
			change.put(coin.getKey(), changeMoney / coinAmount);
			changeMoney = changeMoney - (coinAmount * (changeMoney / coinAmount));
		}
	}
}
