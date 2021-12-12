package vendingmachine.enums;

import static vendingmachine.enums.ErrorMessage.*;

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

	public int get() {
		return amount;
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NO_SUCH_AMOUNT_ERROR_MESSAGE.get()));
	}

	public static List<Integer> getAmounts() {
		return Arrays.stream(Coin.values())
			.map(Coin::get)
			.collect(Collectors.toList());
	}
}
