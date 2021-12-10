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

	// TODO: find, get 등으로 간략하게 네이밍 변경
	public UserBalance getUserBalance() {
		return this.userBalance;
	}

	// TODO: update 등으로 네이밍 변경
	public void setUserBalance(UserBalance userBalance) {
		this.userBalance = userBalance;
	}
}
