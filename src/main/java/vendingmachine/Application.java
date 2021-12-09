package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
		int amount = inputExchangeAmount();
		Coins coins = generateCoins(amount);
		printExchangeCoins(coins);
	}

	private static void printExchangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}

	private static Coins generateCoins(int amount) {
		Coins coins = new Coins();

		while (amount != 0) {
			Coin coin = pickRandomCoin();

			if (amount >= coin.getAmount()) {
				amount -= coin.getAmount();
				coins.put(coin);
			}
		}

		return coins;
	}

	private static Coin pickRandomCoin() {
		int amount = Randoms.pickNumberInList(Arrays.asList(10, 50, 100, 500));
		return Coin.valueOf(amount);
	}

	private static int inputExchangeAmount() {
		printInputMessage();
		String value = inputValue();
		checkIsValid(value);
		return Integer.valueOf(value);
	}

	private static void checkIsValid(String value) {
		checkIsNumber(value);
		checkIsTenTimesNumber(value);
	}

	private static void checkIsTenTimesNumber(String value) {
		Integer amount = Integer.valueOf(value);
		if (amount % 10 != 0) {
			throw new IllegalArgumentException("[ERROR] 자판기가 보유할 금액은 10원으로 나눠어 떨어져야 합니다.");
		}
	}

	private static void checkIsNumber(String value) {
		if (!value.matches("[0-9]*")) {
			throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
		}
	}

	private static String inputValue() {
		String value = Console.readLine();
		return value;
	}

	private static void printInputMessage() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}
}
