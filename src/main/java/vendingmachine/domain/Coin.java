package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	public static List<Coin> coins = new ArrayList<>();

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public static List<Coin> init(){
		coins.add(COIN_10);
		coins.add(COIN_50);
		coins.add(COIN_100);
		coins.add(COIN_500);
		return coins;
	}

	public int getAmount() {
		return this.amount;
	}
}
