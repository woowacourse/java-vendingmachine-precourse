package vendingmachine.model.machine;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;

public class VendingMachine {
	private final Coins coins;
	private int inputMoney;

	public VendingMachine(Coins coins, int inputMoney) {
		this.coins = coins;
		this.inputMoney = inputMoney;
	}

	public void sell(Item item) {
		inputMoney -= item.getPrice();
		item.sell();
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public boolean isOverAndEqualMoney(Item item) {
		return item.isOverAndEqualPrice(inputMoney);
	}

	public Coins getRemainInputMoney() {
		return coins;
	}
}
