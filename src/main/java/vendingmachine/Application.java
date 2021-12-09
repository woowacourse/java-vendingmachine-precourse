package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import vendingmachine.model.Coin;
import vendingmachine.model.Coins;
import vendingmachine.model.Item;
import vendingmachine.reader.ExchangeAmountReader;
import vendingmachine.reader.InputMoneyReader;
import vendingmachine.reader.ItemListReader;

public class Application {
	public static void main(String[] args) {
		int amount = ExchangeAmountReader.create().read();
		Coins coins = generateCoins(amount);
		printExchangeCoins(coins);
		List<Item> items = ItemListReader.create().read();
		int inputMoney = InputMoneyReader.create().read();
		printInputMoney(inputMoney);
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

	private static void printInputMoney(int inputMoney) {
		System.out.println("투입 금액: " + inputMoney);
	}
}
