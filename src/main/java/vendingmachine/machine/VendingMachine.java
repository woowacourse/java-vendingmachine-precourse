package vendingmachine.machine;

import java.util.HashMap;

import vendingmachine.money.Coin;
import vendingmachine.product.ProductStorage;
import vendingmachine.slot.ChangeSlot;
import vendingmachine.slot.InsertSlot;

public class VendingMachine {
	private ChangeSlot changeSlot;
	private ProductStorage productStorage;
	private InsertSlot insertSlot;

	public VendingMachine(ChangeSlot changeSlot, ProductStorage productStorage) {
		this.changeSlot = changeSlot;
		this.productStorage = productStorage;
		this.insertSlot = new InsertSlot();
	}

	public boolean isUsable() {
		return productStorage.isSellable(insertSlot.getRemainMoney());
	}

	public void insertMoney(String money) {
		insertSlot.insert(money);
	}

	public int calculateRemainMoney() {
		return insertSlot.getRemainMoney();
	}

	public void trade(String product) {
		insertSlot.payProductValue(productStorage.sellProduct(product));
	}

	public HashMap<Coin, Integer> returnChange() {
		return changeSlot.calculateChange(insertSlot.getRemainMoney());
	}
}
