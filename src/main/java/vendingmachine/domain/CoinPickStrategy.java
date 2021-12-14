package vendingmachine.domain;

public interface CoinPickStrategy {
	Coin pickOne(Money money);
}
