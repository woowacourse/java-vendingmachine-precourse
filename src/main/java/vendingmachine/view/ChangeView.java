package vendingmachine.view;

import vendingmachine.constant.Message;
import vendingmachine.model.Change;
import vendingmachine.model.Coin;

public class ChangeView {

	public void print(Change change) {
		StringBuilder stringBuilder = new StringBuilder(Message.OUTPUT_MESSAGE_CHANGE);

		for (Coin coin : Coin.values()) {
			int coinAmount = coin.getAmount();
			int coinCount = change.getCoinCount(coin.name());

			if (coinCount > 0) {
				stringBuilder.append("\n" + Message.toString(coinAmount, coinCount));
			}

		}

		stringBuilder.append("\n");
		System.out.println(stringBuilder);
	}
}
