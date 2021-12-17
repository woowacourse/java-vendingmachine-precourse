package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현

	public int getAmount() {
		return amount;
	}

	public static Coin fromMoney(int money) {
		for (Coin type : values()) {
			if (type.getAmount() == money) {
				return type;
			}
		}
		return null;
	}

	public static List<Coin> getCoinList(){
		return Arrays.stream(Coin.values()).collect(Collectors.toList());
	}

}
