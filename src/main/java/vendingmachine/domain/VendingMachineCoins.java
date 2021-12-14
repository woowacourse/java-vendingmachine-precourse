package vendingmachine.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.type.Coin;

public class VendingMachineCoins {

	private final Map<Coin, Integer> coins;

	public VendingMachineCoins(Money vendingMachineMoney) {
		this.coins = generateVendingMachineCoins(vendingMachineMoney);
	}

	public List<Coin> getKeys() {
		return new ArrayList<>(coins.keySet());
	}

	public int getAmount(Coin coin) {
		return coins.get(coin);
	}

	private Map<Coin, Integer> generateVendingMachineCoins(Money vendingMachineMoney) {
		Map<Coin, Integer> coinsMap = new EnumMap<>(Coin.class);
		initializeCoinMap(coinsMap);
		while (vendingMachineMoney.hasMoreMoney()) {
			int amount = Randoms.pickNumberInList(Coin.getCoinList());
			if (vendingMachineMoney.isPossibleChangeToCoin(amount)) {
				addCoin(coinsMap, amount);
				vendingMachineMoney.changeToCoin(amount);
			}
		}
		return coinsMap;
	}

	private void initializeCoinMap(Map<Coin, Integer> coinsMap) {
		for (Coin coin : Coin.values()) {
			coinsMap.put(coin, 0);
		}
	}

	public void addCoin(Map<Coin, Integer> coinsMap, int amount) {
		Coin coinType = Coin.findCoinType(amount);
		coinsMap.put(coinType, coinsMap.get(coinType) + 1);
	}
}
