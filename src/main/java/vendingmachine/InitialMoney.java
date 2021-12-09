package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class InitialMoney {
	private static final String NOT_INTEGER = "자판기가 보유하는 금액은 숫자만 입력이 가능합니다.";
	private static final String NOT_POSITIVE = "자판기가 보유하는 금액은 0보다 커야합니다.";
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int NONE = 0;
	private static final String NOT_DIVISIBLE_BY_TEN = "자판기가 보유하는 금액은 10원으로 나누어떨어져야 합니다.";
	private int money;

	public void input(String money) {
		validateInteger(money);
		validatePositive();
		validateDivisibleByTen();
	}

	private void validateInteger(String money) {
		try {
			this.money = Integer.parseInt(money);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(NOT_INTEGER);
		}
	}

	private void validatePositive() {
		if (money <= 0) {
			throw new IllegalArgumentException(NOT_POSITIVE);
		}
	}

	private void validateDivisibleByTen() {
		if (Math.floorMod(money, MINIMUM_DIVISIBLE_NUMBER) != NONE) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_TEN);
		}
	}

	public List<Integer> createRandomCoins() {
		List<Integer> possibleCoins = getAllPossibleCoins();
		List<Integer> coins = new ArrayList<>();
		do {
			addRandomCoin(possibleCoins, coins);
		} while (money > 0);
		return coins;
	}

	private List<Integer> getAllPossibleCoins() {
		List<Integer> possibleCoins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			possibleCoins.add(coin.getAmount());
		}
		return possibleCoins;
	}

	private void addRandomCoin(List<Integer> possibleCoins, List<Integer> coins) {
		int number = Randoms.pickNumberInList(possibleCoins);
		if (money >= number) {
			money -= number;
			coins.add(number);
		}
	}
}
