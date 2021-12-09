package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.repository.VendingMachine;
import vendingmachine.util.Symbol;

public class VendingMachineService {
	private static final int ZERO = 0;
	private static final List<Integer> coin_kind = Arrays.asList(Coin.COIN_10.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_500.getAmount());

	private final VendingMachine vendingMachine;

	public VendingMachineService() {
		this.vendingMachine = new VendingMachine(coin_kind);
	}

	public void changeMoneyToCoin(int money) {
		while (money > ZERO) {
			int coin = Randoms.pickNumberInList(coin_kind);
			if (canChange(money, coin)) {
				vendingMachine.addCoin(Coin.fromMoney(coin));
				money -= coin;
			}
		}
	}

	public String getMachineSmallChange() {
		return vendingMachine.getCurrentMachineCoin();
	}

	public void saveItem(String itemInfo) {
		List<String> listOfInfo = Arrays.asList(decodeInput(itemInfo));
		listOfInfo.stream().map(s -> s.split(","))
			.forEach(s -> vendingMachine.addItem(s[0], new Item(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]))));
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

	private String[] decodeInput(String itemInfo) {
		itemInfo = itemInfo.replaceAll(Symbol.OPEN_BRACES, Symbol.NULL);
		itemInfo = itemInfo.replaceAll(Symbol.CLOSE_BRACES, Symbol.NULL);
		return itemInfo.split(Symbol.SEMICOLON);
	}

	private boolean canChange(int money, int coin) {
		if (money - coin >= ZERO) {
			return true;
		}
		return false;
	}

	public void printCoins() {
		vendingMachine.printCoins();
	}

}
