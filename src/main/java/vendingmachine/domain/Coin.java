package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final int TEN = 10;
	private static final int FIFTIETH = 50;
	private static final int ONE_HUNDRED = 100;
	private static final int FIVE_HUNDRED = 500;

	private final int amount;
	private static final Map<Integer, Coin> coins;

	static {
		coins = new HashMap<>();
		coins.put(TEN, COIN_10);
		coins.put(FIFTIETH, COIN_50);
		coins.put(ONE_HUNDRED, COIN_100);
		coins.put(FIVE_HUNDRED, COIN_500);
	}

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public static Coin of(int amount) {
        //예외처리 필요
        return coins.get(amount);
    }
}
