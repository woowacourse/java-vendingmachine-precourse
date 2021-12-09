package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import vendingmachine.reader.ExchangeAmountReader;

public class Application {
	public static void main(String[] args) {
		int amount = new ExchangeAmountReader().read();
		Coins coins = generateCoins(amount);
		printExchangeCoins(coins);
		List<Item> items = inputItemList();
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

	private static void printExchangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.stream().forEach(coin -> System.out.println(coin.getAmount() + "원 - " + coins.getCount(coin) + "개"));
	}

	private static List<Item> inputItemList() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String value = Console.readLine();
		String[] items = value.split(";");
		for (String item : items) {
			System.out.println(item);
		}
		return null;
	}
}
