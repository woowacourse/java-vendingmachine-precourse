package vendingmachine.domain;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	public int holdingMoney;
	public int inputMoney;
	public List<Item> itemList;
	public HashMap<Coin, Integer> coinCount;

	public void minusInputMoney(int itemPrice) {
		inputMoney -= itemPrice;
	}

	public HashMap<Coin, Integer> calculateChange() {
		Coin[] coinArray = Coin.getCoinArray();
		int money = inputMoney;
		HashMap<Coin, Integer> change = new HashMap<>();
		for (Coin coin : coinArray) {
			change.put(coin, 0);
		}
		for (Coin coin : coinArray) {
			if (money / coin.getAmount() > 0 && money / coin.getAmount() <= coinCount.get(coin)) {
				change.put(coin, money / coin.getAmount());
				money %= coin.getAmount();
			} else if (money / coin.getAmount() > 0 && money / coin.getAmount() > coinCount.get(coin)){
				change.put(coin,coinCount.get(coin));
				money -= coin.getAmount() * coinCount.get(coin);
			}
		}
		return change;
	}
}
