package vendingmachine.view;

import static vendingmachine.utils.Message.*;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class Output {

	public static void holdingAmount(Coins coins) {
		StringBuilder message = new StringBuilder();
		message.append(HOLDING_COINS_OUTPUT_MESSAGE);
		coins.getList()
			.forEach((coin, count) -> message.append(coin.toString())
				.append(count)
				.append(COIN_COUNT)
				.append("\n"));

		System.out.println(message);
	}

	public static void inputAmount(int amount) {
		String message = INPUT_AMOUNT_OUTPUT_MESSAGE
			+ amount
			+ AMOUNT_OUTPUT_FORMAT;

		System.out.println(message);
	}

	public static void change(Map<Coin, Integer> coins) {
		StringBuilder message = new StringBuilder();
		message.append(CHANGE_MESSAGE);
		coins.forEach((coin, count) -> message.append(coin.toString())
			.append(count)
			.append(COIN_COUNT)
			.append("\n")
		);

		System.out.print(message);
	}
}
