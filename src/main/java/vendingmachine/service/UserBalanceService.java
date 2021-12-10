package vendingmachine.service;

import vendingmachine.domain.item.ItemPrice;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.repository.UserBalanceRepository;

public class UserBalanceService {
	private static UserBalanceService userBalanceService = new UserBalanceService();
	private static UserBalanceRepository userBalanceRepository = UserBalanceRepository.getInstance();

	private UserBalanceService() {
	}

	public static UserBalanceService getInstance() {
		return userBalanceService;
	}

	public void initUserBalance(UserBalance userBalance) {
		userBalanceRepository.setUserBalance(userBalance);
	}

	public UserBalance getUserBalance() {
		return userBalanceRepository.getUserBalance();
	}

	public void subtractUserBalance(ItemPrice itemPrice) {
		UserBalance subtractedUserBalance = userBalanceRepository.getUserBalance().subtract(itemPrice);
		userBalanceRepository.setUserBalance(subtractedUserBalance);
	}
}
