package vendingmachine.service;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.repository.UserBalanceRepository;

public class UserBalanceService {
	private static final UserBalanceRepository userBalanceRepository = UserBalanceRepository.getInstance();

	public void initUserBalance(UserBalance userBalance) {
		userBalanceRepository.update(userBalance);
	}

	public UserBalance getUserBalance() {
		return userBalanceRepository.get();
	}
}
