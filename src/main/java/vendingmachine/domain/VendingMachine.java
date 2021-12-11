package vendingmachine.domain;

import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private final Money vendingMachineMoney;
	private Merchandises merchandises;
	private final LinkedHashMap<Coin, Integer> coinCounts;
	private final LinkedHashMap<Coin, Integer> returnCoinCounts;

	public VendingMachine(Money vendingMachineMoney) {
		this.vendingMachineMoney = vendingMachineMoney;
		coinCounts = new LinkedHashMap<>();
		initCoinCounts(coinCounts);
		returnCoinCounts = new LinkedHashMap<>();
		initCoinCounts(returnCoinCounts);
	}

	public Merchandises getMerchandises() {
		return merchandises;
	}

	public Money getVendingMachineMoney() {
		return vendingMachineMoney;
	}

	public void initCoinCounts(LinkedHashMap<Coin, Integer> coinMap) {
		for (Coin coin : Coin.values()) {
			coinMap.put(coin, 0);
		}
	}

	public void plusCoin(Coin coin) {
		coinCounts.put(coin, coinCounts.get(coin) + 1);
	}

	public void updateReturnCoinMap(Coin coin, int changeCount) {
		returnCoinCounts.put(coin, changeCount);
	}

	public void stockMerchandises(Merchandises merchandises) {
		this.merchandises = merchandises;
	}

	public LinkedHashMap<Coin, Integer> saveCoinStatus() {
		int tempMoney = vendingMachineMoney.getMoney();
		while (tempMoney != 0) {
			int randomCoinValue = Randoms.pickNumberInList(Coin.generateCoinAmountList());
			if (randomCoinValue > tempMoney) {
				continue;
			}
			tempMoney -= randomCoinValue;
			plusCoin(Coin.findCoinByAmount(randomCoinValue));
		}
		return coinCounts;
	}

	public int returnCoin(int changeMoney, Coin coin) {
		int coinChangeMaxCount = changeMoney / coin.getAmount();
		int returnCoinCount = Math.min(coinChangeMaxCount, coinCounts.get(coin));
		changeMoney -= returnCoinCount * coin.getAmount();
		updateReturnCoinMap(coin, returnCoinCount);
		return changeMoney;
	}

	public LinkedHashMap<Coin, Integer> changeCoinStatus(Money lastMoney) {
		int returnMoney = lastMoney.getMoney();
		if (returnMoney >= vendingMachineMoney.getMoney()) {
			return coinCounts;
		}
		for (Coin coin : coinCounts.keySet()) {
			returnMoney = returnCoin(returnMoney, coin);
			if (returnMoney == 0) {
				break;
			}
		}
		return returnCoinCounts;
	}
}
