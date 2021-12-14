package vendingmachine.domain;

import static vendingmachine.utils.Random.*;
import static vendingmachine.utils.Message.*;

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
		int pickAmount = pickRandomCoin(getAmounts());
		return getCoinByAmount(pickAmount);
	}

	private static List<Integer> getAmounts() {
		return Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	private static Coin getCoinByAmount(int pickAmount) {
		return Stream.of(Coin.values())
			.filter(coin -> coin.amount == pickAmount)
			.findFirst()
			.orElse(null);
	}

	public boolean isEnoughAmount(int holdingAmount) {
    	return holdingAmount >= amount;
	}

	public int calculateAmount(int holdingAmount) {
    	return holdingAmount - amount;
	}

	public int calculateCount(int totalAmount, int count) {
		return Math.min(totalAmount / amount, count);
	}

	public int calculateChange(int totalAmount, int count) {
		return totalAmount - (amount * count);
	}

	@Override
	public String toString() {
		return amount + COIN_PRINT_FORMAT;
	}
}
