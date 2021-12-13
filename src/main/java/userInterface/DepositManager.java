package userInterface;

import utils.InputManager;
import vendingmachine.Amount;
import utils.validator.isAmount;

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
		isAmount validator = new isAmount();
		String input = new InputManager().getStringWithInput(validator);
		int amount = Integer.parseInt(input);
		deposit = new Amount(amount);
	}

	public void printDeposit() {
		System.out.println();
		System.out.printf("투입 금액 : %d원\n", deposit.get());
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
