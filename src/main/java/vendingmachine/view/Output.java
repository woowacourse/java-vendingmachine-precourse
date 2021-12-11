package vendingmachine.view;

import static vendingmachine.utils.Message.*;

import vendingmachine.domain.Coins;

public class Output {

	public static void holdingAmount(Coins coins) {
		System.out.println(HOLDING_COINS_OUTPUT_MESSAGE);
		StringBuilder message = new StringBuilder();
		coins.getList()
			.forEach((coin, count) -> message.append(coin.getAmount())
				.append(COIN_PRINT_FORMAT)
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

	public static void change(Coins coins) {
		System.out.println(CHANGE_MESSAGE);
		StringBuilder message = new StringBuilder();
		coins.getList()
			.forEach((coin, count) -> {
				if (count != 0) {
					message.append(coin.getAmount())
						.append(COIN_PRINT_FORMAT)
						.append(count)
						.append(COIN_COUNT)
						.append("\n");
				}
			});

		System.out.println(message);
	}
}
