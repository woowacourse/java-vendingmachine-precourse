package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class User {
	private Money money;
	private List<Merchandise> buyingMerchandiseList;
	private LinkedHashMap<Coin, Integer> changeCoinCounts;

	public User(Money money) {
		this.money = money;
		changeCoinCounts = new LinkedHashMap<>();
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public void buyMerchandise(String merchandiseName, Merchandises merchandises){
		buyingMerchandiseList = new ArrayList<>();
		Merchandise buyingMerchandise = merchandises.selectMerchandise(merchandiseName);
		if (buyingMerchandise != null) {
			buyingMerchandiseList.add(buyingMerchandise);
			setMoney(new Money(money.getMoney()-buyingMerchandise.getMoney().getMoney()));
		}
	}

	public LinkedHashMap<Coin,Integer> saveCoinStatus() {
		int changeMoney = money.getMoney();
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
