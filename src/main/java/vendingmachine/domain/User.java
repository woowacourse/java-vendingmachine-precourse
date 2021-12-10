package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class User {
	private Money userMoney;
	private List<Merchandise> buyingMerchandiseList;
	private LinkedHashMap<Coin, Integer> changeCoinCounts;

	public User(Money userMoney) {
		this.userMoney = userMoney;
		changeCoinCounts = new LinkedHashMap<>();
	}

	public Money getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(Money userMoney) {
		this.userMoney = userMoney;
	}

	public void buyMerchandise(String merchandiseName, Merchandises merchandises){
		buyingMerchandiseList = new ArrayList<>();
		Merchandise buyingMerchandise = merchandises.selectMerchandise(merchandiseName);
		if (buyingMerchandise != null) {
			buyingMerchandiseList.add(buyingMerchandise);
			setUserMoney(new Money(userMoney.getMoney()-buyingMerchandise.getMoney().getMoney()));
		}
	}

	public LinkedHashMap<Coin,Integer> saveCoinStatus() {
		int changeMoney = userMoney.getMoney();
		for (Coin coinValue : Coin.values()) {
			int coinCount = userMoney.decideCoinCount(changeMoney, coinValue);
			if (coinCount != 0) {
				changeCoinCounts.put(coinValue, coinCount);
				changeMoney -= changeCoinCounts.get(coinValue) * coinValue.getAmount();
			}
		}
		return changeCoinCounts;
	}
}
