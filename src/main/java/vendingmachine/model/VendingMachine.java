package vendingmachine.model;

public class VendingMachine {
	private final Coins coins;
	private final ItemRepository itemRepository;
	private int inputMoney;

	public VendingMachine(Coins coins, ItemRepository itemRepository, int inputMoney) {
		this.coins = coins;
		this.itemRepository = itemRepository;
		this.inputMoney = inputMoney;
	}

	public void sell(Item item) {
		inputMoney -= item.getPrice();
		item.sell();
	}

	public int getInputMoney() {
		return inputMoney;
	}
}
