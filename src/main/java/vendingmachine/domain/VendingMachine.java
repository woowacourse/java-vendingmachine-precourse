package vendingmachine.domain;

import java.util.LinkedHashMap;

public class VendingMachine {
	private Money money;
	private LinkedHashMap<Coin, Integer> coinCounts;
	private Merchandises merchandises;
	private LinkedHashMap<Coin, Integer> changeCoinCounts;

	public VendingMachine(Money money) {
		this.money = money;
		coinCounts = new LinkedHashMap<>();
		changeCoinCounts = new LinkedHashMap<>();
	}

	public Merchandises getMerchandises() {
		return merchandises;
	}

	public LinkedHashMap<Coin,Integer> saveCoinStatus() {
		int tempMoney = money.getMoney();
		for (Coin coinValue : Coin.values()) {
			int coinCount = money.decideCoinCount(tempMoney, coinValue);
			coinCounts.put(coinValue, coinCount);
			tempMoney -= coinCounts.get(coinValue) * coinValue.getAmount();
		}
		return coinCounts;
	}

	public void stockMerchandises(Merchandises merchandises) {
		this.merchandises = merchandises;
	}

	public Money getMoney() {
		return money;
	}

	public LinkedHashMap<Coin,Integer> changeCoinStatus(Money lastMoney) {
		int changeMoney = lastMoney.getMoney();
		for (Coin coinValue : Coin.values()) {
			int coinCount = money.decideCoinCount(changeMoney, coinValue);
			if (coinCount != 0) {
				changeCoinCounts.put(coinValue, coinCount);
				changeMoney -= changeCoinCounts.get(coinValue) * coinValue.getAmount();
			}
		}
		return changeCoinCounts;
	}
}
