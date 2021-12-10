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
		insertAmount = insertAmount - item.getPrice();
	}

	public boolean isInsertAmountEnough(int required) {
		return insertAmount >= required;
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
}
