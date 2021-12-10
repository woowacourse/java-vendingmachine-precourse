package vendingmachine.slot;

import vendingmachine.money.Money;

public class InsertSlot {
	private static final String PREFIX = "자판기에 투입하는 ";
	private static final String NOT_ENOUGH_MONEY = "잔액 부족으로 해당 상품을 구매할 수 없습니다.";

	private Money moneyForBuying;

	public void insert(String money) {
		this.moneyForBuying = new Money(money, PREFIX);
	}

	public int getRemainMoney() {
		return moneyForBuying.getAmount();
	}

	public void payProductValue(int productValue) {
		validateEnoughMoney(productValue);
		moneyForBuying.pay(productValue);
	}

	private void validateEnoughMoney(int productValue) {
		if (moneyForBuying.isNotEnough(productValue)) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
		}
	}
}
