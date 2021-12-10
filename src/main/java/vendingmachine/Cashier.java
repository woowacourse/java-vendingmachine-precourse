package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자판기의 동전을 관리하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Cashier {
	private int insertAmount;

	public Cashier(int holdingAmount) {
		makeCoins(holdingAmount);
	}

	public int getInsertAmount() {
		return insertAmount;
	}

	public void insertMoney(int insertAmount) {
		this.insertAmount = insertAmount;
	}

	public void payItem(Item item) {
		payMoney(item.getPrice());
	}

	public boolean isInsertAmountEnough(int required) {
		return insertAmount >= required;
	}

	public void giveChanges() {
		for (Coin coin : Coin.values()) {
			int count = countCoinForChange(coin);
			if (count > 0) {
				payMoney(coin.take(count));
			}
			if (insertAmount < 10) {
				break;
			}
		}
	}

	private void makeCoins(int holdingAmount) {
		do {
			int coinAmount = Randoms.pickNumberInList(Coin.getAmounts());
			if (coinAmount <= holdingAmount) {
				Coin.findByAmount(coinAmount).add();
				holdingAmount = holdingAmount - coinAmount;
			}
		} while (holdingAmount > 0);
	}

	private void payMoney(int amount) {
		insertAmount = insertAmount - amount;
	}

	private int countCoinForChange(Coin coin) {
		int required = coin.divideByAmount(insertAmount);
		int count = required;
		if (coin.remainLessThen(required)) {
			count = coin.getCount();
		}
		return count;
	}
}
