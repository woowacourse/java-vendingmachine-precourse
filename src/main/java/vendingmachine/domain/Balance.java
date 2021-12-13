package vendingmachine.domain;

public class Balance {
	private static final int BALANCE_MINIMUM = 100;
	private static final int BALANCE_DIVISION_STANDARD = 10;
	private static final int BALANCE_ZERO = 0;
	private static final String ERROR_BALANCE_NOT_PURCHASE = "해당 잔액으로 구매할 수 없습니다.";

	private final int balance;

	private Balance(int balance) {
		this.balance = balance;
	}

	public static Balance from(int balance) {
		isValidateBalanceMiniMum(balance);
		isValidateBalance10PercentDivision(balance);
		return new Balance(balance);
	}

	private static void isValidateBalanceMiniMum(int balance) {
		if (balance < BALANCE_MINIMUM) {
			throw new IllegalArgumentException("투입 금액은 100원 이상이여야 합니다.");
		}
	}

	private static void isValidateBalance10PercentDivision(int balance) {
		if (balance % BALANCE_DIVISION_STANDARD != BALANCE_ZERO) {
			throw new IllegalArgumentException("투입 금액은 10원으로 나누어 떨어져야 합니다.");
		}
	}

	public boolean isValidateHasBalanceZero() {
		return this.balance == BALANCE_ZERO;
	}

	public Balance payment(Price price) {
		final int calculate = balance - price.getPrice();
		isValidatePaymentCalculateMinus(calculate);

		return new Balance(calculate);
	}

	private void isValidatePaymentCalculateMinus(int calculate) {
		if (calculate < BALANCE_ZERO) {
			throw new IllegalArgumentException(ERROR_BALANCE_NOT_PURCHASE);
		}
	}

	public int getBalance() {
		return balance;
	}
}
