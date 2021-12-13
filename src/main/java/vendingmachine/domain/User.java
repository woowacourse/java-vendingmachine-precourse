package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final Money userMoney;
	private final List<Merchandise> buyingMerchandiseList;

	public User(Money userMoney) {
		this.userMoney = userMoney;
		buyingMerchandiseList = new ArrayList<>();
	}

	public Money getUserMoney() {
		return userMoney;
	}

	public void buyMerchandise(String merchandiseName, Merchandises merchandises) {
		Merchandise buyingMerchandise = merchandises.selectMerchandise(merchandiseName);
		buyingMerchandise.deductQuantity();
		buyingMerchandiseList.add(buyingMerchandise);
		userMoney.deductMoney(buyingMerchandise.getMoney().getMoney());
	}
}
