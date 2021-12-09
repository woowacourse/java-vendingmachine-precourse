package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import vendingmachine.reader.ExchangeAmountReader;
import static java.util.stream.Collectors.toList;

public class Application {
	public static void main(String[] args) {
		int amount = new ExchangeAmountReader().read();
		Coins coins = generateCoins(amount);
		printExchangeCoins(coins);
		List<Item> items = inputItemList();
		System.out.println(items);
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
		return convertToItemList(splitByComma(removeBracket(splitBySemicolon(value))));
	}

	private static List<Item> convertToItemList(List<String[]> splitByComma) {
		return splitByComma.stream().map(item -> Item.of(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2]))).collect(toList());
	}

	private static List<String[]> splitByComma(List<String> removeBracket) {
		return removeBracket.stream().map(item -> item.split(",")).collect(toList());
	}

	private static List<String> removeBracket(String[] items) {
		return Stream.of(items).map(item -> item.substring(1, item.length() - 1)).collect(toList());
	}

	private static String[] splitBySemicolon(String value) {
		return value.split(";");
	}
}
