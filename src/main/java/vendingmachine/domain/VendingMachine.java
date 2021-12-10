package vendingmachine.domain;

import java.util.LinkedHashMap;

public class VendingMachine {
	private Money vendingMachineMoney;
	private LinkedHashMap<Coin, Integer> coinCounts;
	private Merchandises merchandises;
	private LinkedHashMap<Coin, Integer> changeCoinCounts;

	public VendingMachine(Money vendingMachineMoney) {
		this.vendingMachineMoney = vendingMachineMoney;
		coinCounts = new LinkedHashMap<>();
		changeCoinCounts = new LinkedHashMap<>();
	}

	public Merchandises getMerchandises() {
		return merchandises;
	}

	public Money getVendingMachineMoney() {
		return vendingMachineMoney;
	}

	public LinkedHashMap<Coin,Integer> saveCoinStatus() {
		int tempMoney = vendingMachineMoney.getMoney();
		for (Coin coinValue : Coin.values()) {
			int coinCount = vendingMachineMoney.decideCoinCount(tempMoney, coinValue);
			coinCounts.put(coinValue, coinCount);
			tempMoney -= coinCounts.get(coinValue) * coinValue.getAmount();
		}
		return coinCounts;
	}

	public void stockMerchandises(Merchandises merchandises) {
		this.merchandises = merchandises;
	}

	public LinkedHashMap<Coin,Integer> changeCoinStatus(Money lastMoney) {
		int changeMoney = lastMoney.getMoney();
		for (Coin coinValue : Coin.values()) {
			int coinCount = vendingMachineMoney.decideCoinCount(changeMoney, coinValue);
			if (coinCount != 0) {
				changeCoinCounts.put(coinValue, coinCount);
				changeMoney -= changeCoinCounts.get(coinValue) * coinValue.getAmount();
			}
		}
		return changeCoinCounts;
	}
}
