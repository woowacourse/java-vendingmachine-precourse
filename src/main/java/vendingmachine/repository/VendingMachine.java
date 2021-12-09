package vendingmachine.repository;

import static vendingmachine.util.InputCondition.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class VendingMachine {
	private static final List<Integer> coin_kind = Arrays.asList(Coin.COIN_10.getAmount(),
		Coin.COIN_50.getAmount(),
		Coin.COIN_100.getAmount(),
		Coin.COIN_500.getAmount());

	private final Coins coins;
	private final Items items;

	public VendingMachine() {
		coins = new Coins(coin_kind);
		items = new Items();

	}

	public void changeToCoin(int money) {
		while (money > ZERO) {
			int coin = Randoms.pickNumberInList(coin_kind);
			if (canChange(money, coin)) {
				coins.addCoin(Coin.fromMoney(coin));
				money -= coin;
			}
		}
	}

	private boolean canChange(int money, int coin) {
		if (money - coin >= ZERO) {
			return true;
		}
		return false;
	}

	public String getCurrentMachineCoin() {
		return coins.getMachineCoin();
	}

	public String subtractCoins(int payMoney) {
		return coins.subtract(payMoney);
	}

	public void addItem(String itemName, Item item) {
		items.addItem(itemName, item);
	}

	public int getMinItemPrice() {
		return items.getMinItemPrice();
	}

	public boolean isAllItemSoldOut() {
		return items.getAllItemsSoldOut();
	}

	public boolean isItemSoldOut(String itemName) {
		return items.getItemSoldOut(itemName);
	}

	public int buyItemAndGetPrice(String item) {
		items.buyItem(item);
		return items.getItemPrice(item);
	}

}
