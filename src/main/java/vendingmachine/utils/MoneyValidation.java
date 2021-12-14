package vendingmachine.utils;

public class MoneyValidation {
	private static final int MIN_COIN_PRICE = 10;

	public static void validateVendingMachineMoney(String vendingMachineMoney) {
		validateIntegerType(vendingMachineMoney);
		int money = Integer.parseInt(vendingMachineMoney);
		validateNotNegative(money);
		validateVendingMachineMoneyDividedByMinCoinPrice(money);
	}

	public static void validateInsertAmount(String insertAmount) {
		validateIntegerType(insertAmount);
		validateNotNegative(Integer.parseInt(insertAmount));
	}

	private static void validateNotNegative(int money) {
		if (money < 0) {
			throw new IllegalArgumentException("금액은 0보다 작을 수 없습니다.");
		}
	}

	private static void validateVendingMachineMoneyDividedByMinCoinPrice(int vendingMachineMoney) {
		if (vendingMachineMoney % MIN_COIN_PRICE != 0) {
			throw new IllegalArgumentException("금액이 " + MIN_COIN_PRICE + "의 배수가 아닙니다.");
		}
	}

	private static void validateIntegerType(String money) {
		try {
			Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("금액이 32비트 정수입력을 벗어났습니다.");
		}
	}
}
