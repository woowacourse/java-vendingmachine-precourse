package vendingmachine.dto;

import vendingmachine.domain.machine.Balance;

public class BalanceDto {
	private static final String WON = "원";

	private int balance;

	public BalanceDto(int balance) {
		this.balance = balance;
	}

	public static BalanceDto from(Balance balance) {
		return new BalanceDto(balance.getBalance());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.append(balance + WON).toString();
	}
}
