package vendingmachine.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class User {
	private Money userMoney;
	private List<Merchandise> buyingMerchandiseList;

	public User(Money userMoney) {
		this.userMoney = userMoney;
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
}
