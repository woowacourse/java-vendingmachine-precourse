package vendingmachine.domain;

public class VendingMachine {
	private Coins coins;
	private Items items;
	private int minItemPrice;
	private int userMoneyAmount;

	public VendingMachine() {
		this.coins = new Coins();
		this.items = new Items();
		this.minItemPrice = items.getMinItemPrice();
		this.userMoneyAmount = 0;
	}

	public void updateMachineCoins(int machineMoney) {
		coins.generateCoins(machineMoney);
	}

	public void updateItem(Item item) {
		items.addItem(item);
		updateMinItemPrice(item);
	}

	private void updateMinItemPrice(Item item) {
		int itemPrice = item.getPrice();
		if (!item.isZeroQuantity() && itemPrice < minItemPrice) {
			minItemPrice = itemPrice;
		}
	}

	public void insertUserMoney(int userMoney) {
		this.userMoneyAmount = userMoney;
	}

	public boolean checkQuantity(String itemName) {
		return items.isSoldOut(itemName);
	}

	public int purchaseItem(String itemName) {
		Item item = items.purchaseItem(itemName);
		checkMinItemPrice(item);
		return userMoneyAmount -= item.getPrice();
	}

	private void checkMinItemPrice(Item item) {
		if (item.getPrice() == minItemPrice && item.isZeroQuantity()) {
			minItemPrice = items.getMinItemPrice();
		}
	}
}
