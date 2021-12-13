package userinterface;

import utils.InputManager;
import utils.validator.IsAmount;
import vendingmachine.Amount;

public class DepositManager {
	private Amount deposit;

	public DepositManager() {
		System.out.println();
		System.out.println("투입 금액을 입력해 주세요.");
		initDeposit();
	}

	public int getDeposit() {
		return deposit.get();
	}

	private void initDeposit() {
		IsAmount validator = new IsAmount();
		String input = new InputManager().getStringWithInput(validator);
		int amount = Integer.parseInt(input);

		deposit = new Amount(amount);
	}

	public void printDeposit() {
		System.out.printf("\n투입 금액: %d원\n", deposit.get());
	}

	public boolean deduct(int price) {
		int depositInt = deposit.get();

		if (depositInt <= price) {
			throw new IllegalArgumentException("[ERROR] 투입 금액보다 큰 상품을 구매할 수 없습니다.");
		}

		deposit = new Amount(depositInt - price);
		return true;
	}
}
