package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.repository.DepositRepository;

public class DepositService {

	private final DepositRepository depositRepository;

	public DepositService(DepositRepository depositRepository) {
		this.depositRepository = depositRepository;
	}

	public String deposit(Money money) {
		return depositRepository.save(money);
	}
}
