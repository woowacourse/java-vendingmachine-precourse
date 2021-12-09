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


}
