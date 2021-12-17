package vendingmachine.service;

public class VendingMachine {
	private static final int ZERO = 0;

	private final CoinService coinService;
	private final ItemService itemService;

	public VendingMachine() {
		this.coinService = new CoinService();
		this.itemService = new ItemService();
	}

	public void toMachineCoin(int money) {
		coinService.changeMoneyToCoin(money);
	}

	public String getInitialSmallChange() {
		return coinService.getMachineSmallChange();
	}

	public void registItem(String itemInfo) {
		itemService.saveItem(itemInfo);
	}

	public boolean canBuyAnything(int remainAmount) {
		return itemService.canBuyAnything(remainAmount);
	}

	public int buyItem(int payMoney, String itemName) {
		return itemService.buyItem(payMoney, itemName);
	}

	public String getResultSmallChange(int remainMoney) {
		return coinService.calculateSmallChange(remainMoney);
	}

}
