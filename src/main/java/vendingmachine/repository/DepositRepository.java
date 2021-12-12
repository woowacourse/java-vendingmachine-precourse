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

	public DepositRepository spit(int money) {
		DepositRepository changes = new DepositRepository();
		spitRecursive(0, money, changes);
		return changes;
	}

	private void spitRecursive(int coinIndex, int moneySum, DepositRepository changes) {
		if (moneySum == 0)
			return;
		if (coinIndex >= Coin.values().length)
			return;
		Coin coin = Coin.values()[coinIndex];
		Deposit deposit = this.findByCoin(coin).orElse(new Deposit(Coin.COIN_10, 0));
		int count = Math.min(moneySum / coin.getAmount(), deposit.getCount());

		moneySum -= coin.getAmount() * count;
		deposit.decreaseBy(count);
		changes.save(new Deposit(coin, count));
		spitRecursive(coinIndex + 1, moneySum, changes);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		depositMap.values().forEach(deposit -> stringBuilder.append(
			String.format(Hint.DEPOSIT_EACH.getHint(), deposit.getCoin().getAmount(), deposit.getCount())));
		return stringBuilder.toString();
	}

	public String toStringSkipZero() {
		StringBuilder stringBuilder = new StringBuilder();
		depositMap.values()
			.stream()
			.filter(deposit -> deposit.getCount() > 0)
			.forEach(deposit -> stringBuilder.append(
				String.format(Hint.DEPOSIT_EACH.getHint(), deposit.getCoin().getAmount(), deposit.getCount())));
		return stringBuilder.toString();
	}
}
