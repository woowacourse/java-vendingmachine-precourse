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

	public UserBalance getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(UserBalance userBalance) {
		this.userBalance = userBalance;
	}
}
