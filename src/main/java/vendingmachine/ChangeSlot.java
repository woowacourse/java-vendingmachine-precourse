package vendingmachine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ChangeSlot {
	private static final String NOT_INTEGER = "자판기가 보유하는 금액은 숫자만 입력이 가능합니다.";
	private static final String NOT_POSITIVE = "자판기가 보유하는 금액은 0보다 커야합니다.";
	private static final String NOT_DIVISIBLE = "자판기가 보유하는 금액은 10원으로 나누어떨어져야 합니다.";
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int ZERO = 0;
	private static final int PLUS_ONE = 1;
	private static final int MINUS_ONE = -1;

	private HashMap<Coin, Integer> coins;
	private int money;

	public void input(String money) {
		validateInteger(money);
		validatePositive();
		validateDivisible();
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

	private void validateDivisible() {
		if (Math.floorMod(money, MINIMUM_DIVISIBLE_NUMBER) != ZERO) {
			throw new IllegalArgumentException(NOT_DIVISIBLE);
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
			coins.put(each, ZERO);
		}
	}

	private void addRandomCoin(List<Integer> possibleCoins) {
		int number = Randoms.pickNumberInList(possibleCoins);
		if (money >= number) {
			money -= number;
			coins.merge(Coin.issue(number), PLUS_ONE, Integer::sum);
		}
	}

	public HashMap<Coin, Integer> calculateChange(int remainMoney) {
		HashMap<Coin, Integer> changeCoins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			remainMoney = changeCoinAsPossible(coin, remainMoney, changeCoins);
		}
		return changeCoins;
	}

	private int changeCoinAsPossible(Coin coin, int remainMoney, HashMap<Coin, Integer> changeCoins) {
		while (coins.get(coin) > ZERO && coin.isChangeable(remainMoney)) {
			remainMoney = coin.change(remainMoney);
			coins.merge(coin, MINUS_ONE, Integer::sum);
			changeCoins.merge(coin, PLUS_ONE, Integer::sum);
		}
		return remainMoney;
	}
}
