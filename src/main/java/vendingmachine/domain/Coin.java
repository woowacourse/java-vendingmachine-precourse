package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.constant.ErrorConst;
import vendingmachine.constant.MessageConst;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin getCoinByAmount(int selectAmount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == selectAmount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ErrorConst.COIN_IS_NOT_VALID));
	}

	public static List<Integer> getCoinAmountList() {
		List<Coin> coins = Arrays.asList(Coin.values());
		return coins.stream().map(Coin::getAmount).collect(Collectors.toList());
	}

	public boolean isDivided(int money) {
		return money % amount == 0;
	}

	public int getValue(int coinNum) {
		return coinNum * amount;
	}

	@Override
	public String toString() {
		return amount + MessageConst.COIN_UNIT;
	}

	public int getAmount() {
		return amount;
	}

	public int getNumDivided(int money) {
		return money / this.amount;
	}
}
