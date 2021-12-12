package vendingmachine.coin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.Money;
import vendingmachine.quantity.Quantity;

public class Coins {
	private final Map<Coin, Quantity> coins;

	protected Coins(Map<Coin, Quantity> coins) {
		this.coins = coins;
	}

	public boolean isEmpty() {
		return coins.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<Coin, Quantity> coin : coins.entrySet()) {
			stringBuilder
				.append(coin.getKey()).append(" - ")
				.append(coin.getValue()).append("\n");
		}
		return stringBuilder.toString();
	}

	public Coins returnChange(Money money) {
		Map<Coin, Quantity> returnCoins = new LinkedHashMap<>();
		List<Coin> sortedCoins = Coin.getSortedCoins();
		for (Coin coin : sortedCoins) {
			calculateChange(coin,money,returnCoins);
		}
		return new Coins(returnCoins);
	}

	public void calculateChange(Coin coin, Money money, Map<Coin, Quantity> returnCoins) {
		Quantity retentionQuantity = coins.get(coin);
		Quantity ableQuantity = coin.exchangeableQuantity(money, retentionQuantity);
		if(!ableQuantity.isZero()) {
			money.spend(coin.getMoney(),ableQuantity);
			retentionQuantity.down(ableQuantity);
			returnCoins.put(coin,ableQuantity);
		}
	}
}
