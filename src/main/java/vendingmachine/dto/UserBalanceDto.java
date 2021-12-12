package vendingmachine.dto;

import vendingmachine.domain.userbalance.UserBalance;

public class UserBalanceDto {
	private final int userBalance;

	private UserBalanceDto(int userBalance) {
		this.userBalance = userBalance;
	}

	public static UserBalanceDto from(int userBalance) {
		return new UserBalanceDto(userBalance);
	}

	public UserBalance toEntity() {
		return UserBalance.from(userBalance);
	}
}
