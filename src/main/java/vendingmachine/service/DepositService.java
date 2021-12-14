package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.Price;
import vendingmachine.repository.DepositRepository;

public class DepositService {

	private final DepositRepository depositRepository;

	public DepositService(DepositRepository depositRepository) {
		this.depositRepository = depositRepository;
	}

	public Money deposit(Money money) {
		return depositRepository.save(money);
	}

	public Money retrieve() {
		return depositRepository.get();
	}

	public Money decrease(Price price) {
		return depositRepository.save(retrieve().minus(price));
	}
}
