package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vendingmachine.domain.money.Money;
import vendingmachine.domain.quantity.Quantity;

public class Coins {
	private final Map<Coin, Quantity> coins;

	public Coins() {
		this.coins = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.getSortedCoins()) {
			coins.put(coin, Quantity.from());
		}
	}

	public void add(Coin coin) {
		coins.computeIfPresent(coin, (originCoin, quantity) -> quantity.up());
	}

	public void add(Coin coin, Quantity quantity) {
		coins.computeIfPresent(coin, (originCoin, originQuantity) -> originQuantity.up(quantity));
	}

	public void removeZeroQuantity() {
		coins.values().removeIf(Quantity::isZero);
	}

	public void addAll(Coins coins) {
		Set<Map.Entry<Coin, Quantity>> coinSet = coins.coins.entrySet();
		for (Map.Entry<Coin, Quantity> coin : coinSet) {
			add(coin.getKey(), coin.getValue());
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<Coin, Quantity> coin : coins.entrySet()) {
			stringBuilder.append(coin.getKey()).append(" - ").append(coin.getValue()).append("\n");
		}
		return stringBuilder.toString();
	}

	public Coins makeReturnChange(Money money) {
		Coins returnCoins = new Coins();
		List<Coin> sortedCoins = Coin.getSortedCoins();
		for (Coin coin : sortedCoins) {
			calculateChange(coin, money, returnCoins);
		}
		returnCoins.removeZeroQuantity();
		return returnCoins;
	}

	public void calculateChange(Coin coin, Money money, Coins returnCoins) {
		Quantity retentionQuantity = coins.get(coin);
		Quantity ableQuantity = coin.exchangeableQuantity(money, retentionQuantity);
		if (!ableQuantity.isZero()) {
			money.spend(coin.getMoney(), ableQuantity);
			retentionQuantity.down(ableQuantity);
			returnCoins.add(coin, ableQuantity);
		}
	}
}
