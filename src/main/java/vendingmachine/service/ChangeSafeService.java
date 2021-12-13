package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Quantity;
import vendingmachine.repository.ChangeSafeRepository;

public class ChangeSafeService {

	private final ChangeSafeRepository repository;

	public ChangeSafeService(ChangeSafeRepository repository) {
		this.repository = repository;
	}

	public String persist(Map<Coin, Quantity> coinMap) {
		return repository.save(new ChangeSafe(coinMap));
	}
}
