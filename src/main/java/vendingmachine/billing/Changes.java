package vendingmachine.billing;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Changes {
	private static final int ZERO = 0;
	private static final int PLUS_ONE = 1;
	private static final int MINUS_ONE = -1;

	private Map<Coin, Integer> coins;
	private Money moneyForChange;

	public void input(Money moneyForChange) {
		this.moneyForChange = moneyForChange;
	}

	public void createRandomCoins() {
		initialCoins();
		while (moneyForChange.isLeft()) {
			addRandomCoin();
		}
	}

	private void initialCoins() {
		coins = new EnumMap<>(Coin.class);
		Arrays.stream(Coin.values()).forEach(each -> coins.put(each, ZERO));
	}

	private void addRandomCoin() {
		int randomCoinValue = Coin.getRandomCoin();
		if (moneyForChange.isChangeable(randomCoinValue)) {
			moneyForChange.change(randomCoinValue);
			coins.merge(Coin.issue(randomCoinValue), PLUS_ONE, Integer::sum);
		}
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}

	public Map<Coin, Integer> calculateChange(Money money) {
		Map<Coin, Integer> changeCoins = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.values()) {
			changeCoinAsPossible(coin, money, changeCoins);
		}
		return changeCoins;
	}

	private void changeCoinAsPossible(Coin coin, Money money, Map<Coin, Integer> changeCoins) {
		while (coins.get(coin) > ZERO && coin.isChangeable(money)) {
			coin.change(money);
			coins.merge(coin, MINUS_ONE, Integer::sum);
			changeCoins.merge(coin, PLUS_ONE, Integer::sum);
		}
	}
}
