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
}
