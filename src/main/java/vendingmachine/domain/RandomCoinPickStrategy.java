package vendingmachine.domain;

public class RandomCoinPickStrategy implements CoinPickStrategy {

	@Override
	public Coin pickOne(Money money) {
		int amount = Coin.pickRandom();
		if (!money.isLessThan(new Money(amount))) {
			return Coin.of(amount);
		}
		return pickOne(money);
	}
}
