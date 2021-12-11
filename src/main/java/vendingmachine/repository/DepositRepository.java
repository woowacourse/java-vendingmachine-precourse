package vendingmachine.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import vendingmachine.constant.Coin;
import vendingmachine.domain.Deposit;

public class DepositRepository {

	private final Map<Coin, Deposit> depositMap;

	public DepositRepository() {
		depositMap = new TreeMap<>();
	}

	public DepositRepository(DepositRepository depositRepository) {
		this.depositMap = new HashMap<>();
		depositRepository.depositMap.values()
			.stream()
			.map(deposit -> new Deposit(deposit.getCoin(), deposit.getCount()))
			.forEach(nd -> depositMap.put(nd.getCoin(), nd));
	}

	public void save(List<Deposit> depositList) {
		depositList.forEach(deposit -> depositMap.put(deposit.getCoin(), deposit));
	}

	public Optional<Deposit> findByCoin(Coin coin) {
		return Optional.ofNullable(depositMap.get(coin));
	}

	public int getDepositTotal() {
		return depositMap.values()
			.stream()
			.mapToInt(deposit -> deposit.getCoin().getAmount() * deposit.getCount())
			.sum();
	}
}
