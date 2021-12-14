package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;

import vendingmachine.utill.ItemConst;

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

	public void generateMachineCoins(int machineMoney) {
		coins.generateCoins(machineMoney);
	}

	public LinkedHashMap<Integer, Integer> getCoinInfo() {
		return coins.getCoinCount();
	}

	public void updateItemList(String item) {
		updateItem(getItemInstance(item));
	}

	private Item getItemInstance(String item) {
		item = item.replace(ItemConst.OPEN_BRACKET, "");
		item = item.replace(ItemConst.CLOSE_BRACKET, "");
		String[] itemInfo = item.split(ItemConst.DELIMITER);

		return new Item(itemInfo[ItemConst.NAME_INDEX],
			Integer.parseInt(itemInfo[ItemConst.PRICE_INDEX]), Integer.parseInt(itemInfo[ItemConst.QUANTITY_INDEX]));
	}

	private void updateItem(Item item) {
		items.addItem(item);
		updateMinItemPrice(item);
	}

	private void updateMinItemPrice(Item item) {
		int itemPrice = item.getPrice();
		if (!item.isZeroQuantity() && itemPrice < minItemPrice) {
			minItemPrice = itemPrice;
		}
	}

	public int insertUserMoney(int userMoney) {
		return this.userMoneyAmount = userMoney;
	}

	public List<String> getItemList() {
		return items.getItemList();
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

	public boolean isExitPoint() {
		return items.hasNoStock() || userMoneyAmount < minItemPrice;
	}

	public LinkedHashMap<Integer, Integer> getChangeInfo() {
		return coins.calculateChange(userMoneyAmount);
	}
}
