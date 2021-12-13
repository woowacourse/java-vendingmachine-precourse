package vendingmachine.dto;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;

public class CoinsDto {
	private static final String HYPHEN = " - ";
	private static final String WON = "원";
	private static final String VALUE = "개";
	private static final String LINE_SEPARATOR = System.lineSeparator();

	private Map<Coin, Integer> coins;

	public CoinsDto(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public static CoinsDto from(Coins coins) {
		return new CoinsDto(coins.getCoins());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<Coin, Integer> coin : coins.entrySet()) {
			builder.append(coin.getKey().getAmount() + WON + HYPHEN + coin.getValue() + VALUE);
			builder.append(LINE_SEPARATOR);
		}

		return builder.toString();
	}
}
