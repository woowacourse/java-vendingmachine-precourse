package vendingmachine.domain.machine.coin;

import vendingmachine.view.output.message.OutputMessage;

public class CoinCountFormatter {

	public static String of(Coin coin, int count) {
		return String.format(OutputMessage.COIN_OUTPUT_FORMAT, coin.getAmount(), count);
	}

}
