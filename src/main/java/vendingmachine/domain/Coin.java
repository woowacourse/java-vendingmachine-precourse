package vendingmachine.domain;

import static vendingmachine.utils.Random.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static Coin pickRandom() {
		int amount = pickRandomCoin(getAmounts());
		return getCoinByAmount(amount);
	}

	public boolean isEnoughAmount(int totalAmount) {
    	return totalAmount >= amount;
	}

	public int calculateAmount(int totalAmount) {
    	return totalAmount - amount;
	}

	public int calculateCount(int totalAmount, int count) {
		return Math.min(totalAmount / amount, count);
	}

	public int calculateChange(int totalAmount, int count) {
		return totalAmount - (amount * count);
	}

	private static List<Integer> getAmounts() {
    	return Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	private static Coin getCoinByAmount(int amount) {
    	return Stream.of(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElse(null);
	}
}
