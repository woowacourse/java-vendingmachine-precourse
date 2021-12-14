package vendingmachine.model.cash.service;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.cash.domain.Coin;
import vendingmachine.model.item.domain.Item;
import vendingmachine.model.shared.Error;
import vendingmachine.model.shared.Validator;

/**
 * 자판기의 동전을 관리하는 model class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class Cashier {
	private static final int AMOUNT_UNIT = 10;
	private static final int MIN_AMOUNT = 0;
	private static final String TO_STRING_PREFIX = "투입 금액: ";
	private static final String TO_STRING_SUFFIX = "원";

	private int insertAmount;

	public Cashier(int holdingAmount) {
		validateAmount(holdingAmount);
		makeCoins(holdingAmount);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(TO_STRING_PREFIX);
		stringBuilder.append(insertAmount);
		stringBuilder.append(TO_STRING_SUFFIX);
		return stringBuilder.toString();
	}

	public void insertMoney(int insertAmount) {
		validateAmount(insertAmount);
		this.insertAmount = insertAmount;
	}

	public void payItem(Item item) {
		payMoney(item.getPrice());
	}

	public boolean isInsertAmountEnough(int required) {
		return insertAmount >= required;
	}

	public void countChanges() {
		for (Coin coin : Coin.values()) {
			payMoney(coin.takeChange(this.insertAmount));
			if (!isInsertAmountEnough(AMOUNT_UNIT)) {
				return;
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

	private void validateAmount(int amount) {
		if (!Validator.isBiggerThenMinValue(amount, MIN_AMOUNT)) {
			throw new IllegalArgumentException(Error.MINUS.getMassage());
		}
		if (!Validator.isDivisible(amount, AMOUNT_UNIT)) {
			throw new IllegalArgumentException(Error.CAN_NOT_BE_DIVIDED_BY_10.getMassage());
		}
	}
}
