package vendingmachine.domain;

import java.util.List;

public class User {
	private Money money;
	private List<Merchandise> buyingMerchandise;

	public User(Money money) {
		this.money = money;
	}

	public void buyMerchandise(Merchandise merchandise, Merchandises merchandises){
		if(merchandises.getMerchandiseList().contains(merchandise)){
			buyingMerchandise.add(merchandise);
		}
	}
}
