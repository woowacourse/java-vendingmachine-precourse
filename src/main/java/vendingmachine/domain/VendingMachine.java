package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.type.Coin;

public class VendingMachine {

	private VendingMachineCoins coins;
	private Products products;
	private Money userMoney;

	public VendingMachine(int vendingMachineMoney) {
		coins = createVendingMachineCoins(vendingMachineMoney);
	}

	private VendingMachineCoins createVendingMachineCoins(int vendingMachineMoney) {
		return new VendingMachineCoins(generateVendingMachineCoins(vendingMachineMoney));
	}

	private Map<Coin, Integer> generateVendingMachineCoins(int vendingMachineMoney) {
		Map<Coin, Integer> coinsMap = new EnumMap<>(Coin.class);
		initializeCoinMap(coinsMap);
		while (vendingMachineMoney > 0) {
			int amount = Randoms.pickNumberInList(Coin.getCoinList());
			if (vendingMachineMoney >= amount) {
				addCoin(coinsMap, amount);
				vendingMachineMoney -= amount;
			}
		}
		return coinsMap;
	}

	private void initializeCoinMap(Map<Coin, Integer> coinsMap) {
		for (Coin coin : Coin.values()) {
			coinsMap.put(coin, 0);
		}
	}

	private void addCoin(Map<Coin, Integer> coinsMap, int amount) {
		Coin coinType = Coin.findCoinType(amount);
		coinsMap.put(coinType, coinsMap.get(coinType) + 1);
	}

	public VendingMachineCoins findCoins() {
		return coins;
	}

	public void addProducts(Products products) {
		this.products = products;
	}

	public void inputMoney(Money money) {
		this.userMoney = money;
	}
}
