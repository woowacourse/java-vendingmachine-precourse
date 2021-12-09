package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.repository.VendingMachine;
import vendingmachine.util.Symbol;

public class VendingMachineService {
	private static final int ZERO = 0;

	private final VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine();
	}

	public void changeMoneyToCoin(int money) {
		vendingMachine.changeToCoin(money);

	}

	public String getMachineSmallChange() {
		return vendingMachine.getCurrentMachineCoin();
	}

	public void saveItem(String itemInfo) {
		List<String> listOfInfo = Arrays.asList(decodeInput(itemInfo));
		listOfInfo.stream().map(s -> s.split(","))
			.forEach(s -> vendingMachine.addItem(s[0], new Item(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]))));
	}

	private String[] decodeInput(String itemInfo) {
		itemInfo = itemInfo.replaceAll(Symbol.OPEN_BRACES, Symbol.NULL);
		itemInfo = itemInfo.replaceAll(Symbol.CLOSE_BRACES, Symbol.NULL);
		return itemInfo.split(Symbol.SEMICOLON);
	}

	public boolean canBuyAnything(int payMoney) {
		if (payMoney < vendingMachine.getMinItemPrice() || vendingMachine.isAllItemSoldOut()) {
			return false;
		}
		return true;
	}

	public int buyItem(int payMoney, String itemName) {
		if (!vendingMachine.isItemSoldOut(itemName)) {
			return payMoney - vendingMachine.buyItemAndGetPrice(itemName);
		}
		return payMoney;
	}

	public String calculateSmallChange(int remainMoney) {
		return vendingMachine.subtractCoins(remainMoney);
	}

}
