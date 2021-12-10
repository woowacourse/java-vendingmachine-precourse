package vendingmachine.machine;

import java.util.HashMap;

import vendingmachine.money.ChangeSlot;
import vendingmachine.money.Coin;
import vendingmachine.money.MoneySlot;
import vendingmachine.product.ProductStorage;

public class VendingMachine {
	private ChangeSlot changeSlot;
	private ProductStorage productStorage;
	private MoneySlot moneySlot;

	public VendingMachine(ChangeSlot changeSlot, ProductStorage productStorage) {
		this.changeSlot = changeSlot;
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

	public HashMap<Coin, Integer> returnChange() {
		return changeSlot.calculateChange(moneySlot.getRemainMoney());
	}
}
