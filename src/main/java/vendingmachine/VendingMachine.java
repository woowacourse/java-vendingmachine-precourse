package vendingmachine;

import java.util.List;

public class VendingMachine {
	private List<Integer> coinsForChange;
	private ProductStorage productStorage;
	private MoneySlot moneySlot;

	public VendingMachine(List<Integer> coinsForChange, ProductStorage productStorage) {
		this.coinsForChange = coinsForChange;
		this.productStorage = productStorage;
		this.moneySlot = new MoneySlot();
	}

	public boolean isUsable() {
		return productStorage.isSellable(moneySlot.getRemainMoney());
	}

	public void insertMoney(String money) {
		moneySlot.insert(money);
	}

	public int calculateRemainMoney() {
		return moneySlot.getRemainMoney();
	}

	public void trade(String product) {
		moneySlot.payProductValue(productStorage.sellProduct(product));
	}
}
