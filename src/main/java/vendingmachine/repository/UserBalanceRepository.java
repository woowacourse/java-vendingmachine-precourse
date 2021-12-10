package vendingmachine.repository;

import vendingmachine.domain.userbalance.UserBalance;

public class UserBalanceRepository {
	private static UserBalanceRepository userBalanceRepository = new UserBalanceRepository();
	private UserBalance userBalance;

	private UserBalanceRepository() {
	}

	public static UserBalanceRepository getInstance() {
		return userBalanceRepository;
	}

	public void update(UserBalance userBalance) {
		this.userBalance = userBalance;
	}

	public UserBalance get() {
		return this.userBalance;
	}
}
