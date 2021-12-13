package vendingmachine.domain;

public class Machine {
	private final int money;
	private Coins coins;
	private Items items;

	public Machine(int money) {
		this.money = money;
		this.coins = new Coins();
	}

	public void makeRandomCoins() {
		coins.makeRandomCoins(money);
	}

	public void sellItem(String buyItem) {
		items.sell(buyItem);
	}

	public Coins calculateChange(int change) {
		Coins changeCoin = this.coins.calculateChange(change);
		return changeCoin;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public String getCoinsList() {
		return coins.toString();
	}

	public int getMinPrice() {
		return items.getMinPrice();
	}

	public boolean isStockNotEmpty() {
		if (items.isStockEmpty()) {
			return false;
		}
		return true;
	}

	public boolean contains(String itemName) {
		return items.contains(itemName);
	}

	public int getQuantity(String itemName) {
		return items.getQuantity(itemName);
	}

	public int getPrice(String itemName) {
		return items.getPrice(itemName);
	}
}
