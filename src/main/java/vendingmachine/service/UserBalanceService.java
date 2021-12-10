package vendingmachine.service;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.repository.UserBalanceRepository;

public class UserBalanceService {
	private static final UserBalanceService userBalanceService = new UserBalanceService();
	private static final UserBalanceRepository userBalanceRepository = UserBalanceRepository.getInstance();

	private UserBalanceService() {
	}

	public static UserBalanceService getInstance() {
		return userBalanceService;
	}

	public void initUserBalance(UserBalance userBalance) {
		userBalanceRepository.update(userBalance);
	}

	public UserBalance getUserBalance() {
		return userBalanceRepository.get();
	}
}
