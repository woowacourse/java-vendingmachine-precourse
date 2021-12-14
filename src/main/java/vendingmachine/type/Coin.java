package vendingmachine.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.constant.Message;

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

	public static Coin findCoinType(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.ERROR_NOT_FOUND_COIN_TYPE));
	}

	public static List<Integer> getCoinList() {
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}
}
