package vendingmachine.domain;

public class VendingMachine {

	private Coins coins;
	private Items items;

	public VendingMachine() {
		coins = new Coins();
		items = new Items();
	}

	public Coins getCoins() {
		return coins;
	}

	public void insertCoins(int amount) {
		coins.insertRandomCoins(amount);
	}

	public void insertItems(String itemList) {
		items.insertItems(itemList);
	}
}
