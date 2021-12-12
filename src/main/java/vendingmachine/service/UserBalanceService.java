package vendingmachine.service;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.dto.UserBalanceDto;
import vendingmachine.repository.UserBalanceRepository;

public class UserBalanceService {
	private static final UserBalanceRepository userBalanceRepository = UserBalanceRepository.getInstance();

	public void initUserBalance(UserBalanceDto userBalanceDto) {
		userBalanceRepository.update(userBalanceDto.toEntity());
	}

	public UserBalance getUserBalance() {
		return userBalanceRepository.get();
	}
}
