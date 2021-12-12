package vendingmachine.view;

import static vendingmachine.utils.Message.*;

import vendingmachine.domain.Coins;

public class Output {

	private static final int OUT_OF_STOCK = 0;

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
				if (count != OUT_OF_STOCK) {
					message.append(coin.getAmount())
						.append(COIN_PRINT_FORMAT)
						.append(count)
						.append(COIN_COUNT)
						.append("\n");
				}
			});

		System.out.print(message);
	}
}
