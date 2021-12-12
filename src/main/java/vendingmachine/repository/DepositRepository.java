package vendingmachine.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import vendingmachine.constant.Coin;
import vendingmachine.constant.Hint;
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

	public void save(DepositRepository depositRepository) {
		depositRepository.depositMap.values().forEach(deposit -> depositMap.put(deposit.getCoin(), deposit));
	}

	public void save(List<Deposit> depositList) {
		depositList.forEach(deposit -> depositMap.put(deposit.getCoin(), deposit));
	}

	public void save(Deposit deposit) {
		depositMap.put(deposit.getCoin(), deposit);
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		depositMap.values().forEach(deposit -> stringBuilder.append(
			String.format(Hint.DEPOSIT_EACH.getHint(), deposit.getCoin().getAmount(), deposit.getCount())));
		return stringBuilder.toString();
	}

	public String toString(boolean skipZero) {
		StringBuilder stringBuilder = new StringBuilder();
		depositMap.values()
			.stream()
			.filter(deposit -> deposit.getCount() > 0)
			.forEach(deposit -> stringBuilder.append(
				String.format(Hint.DEPOSIT_EACH.getHint(), deposit.getCoin().getAmount(), deposit.getCount())));
		return stringBuilder.toString();
	}
}
