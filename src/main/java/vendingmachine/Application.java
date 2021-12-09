package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import vendingmachine.reader.ExchangeAmountReader;

public class Application {
	public static void main(String[] args) {
		int amount = new ExchangeAmountReader().read();
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
}
