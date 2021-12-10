package vendingmachine;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ChangeSlot {
	private static final String NOT_INTEGER = "자판기가 보유하는 금액은 숫자만 입력이 가능합니다.";
	private static final String NOT_POSITIVE = "자판기가 보유하는 금액은 0보다 커야합니다.";
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int ZERO = 0;
	private static final String NOT_DIVISIBLE_BY_TEN = "자판기가 보유하는 금액은 10원으로 나누어떨어져야 합니다.";

	private HashMap<Coin, Integer> coins;
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
		if (money <= ZERO) {
			throw new IllegalArgumentException(NOT_POSITIVE);
		}
	}

	private void validateDivisibleByTen() {
		if (Math.floorMod(money, MINIMUM_DIVISIBLE_NUMBER) != ZERO) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_TEN);
		}
	}

	public HashMap<Coin, Integer> createRandomCoins() {
		initialCoins();
		List<Integer> possibleCoins = Coin.getAllCoins();
		while (money > ZERO) {
			addRandomCoin(possibleCoins);
		}
		return coins;
	}

	private void initialCoins() {
		coins = new HashMap<>();
		for (Coin each : Coin.values()) {
			coins.put(each, 0);
		}
	}

	private void addRandomCoin(List<Integer> possibleCoins) {
		int number = Randoms.pickNumberInList(possibleCoins);
		if (money >= number) {
			money -= number;
			coins.merge(Coin.issue(number), 1, Integer::sum);
		}
	}
}
