package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Coin;
import vendingmachine.model.HoldingSum;

public class HoldingSumView {

	public HoldingSum getInput() {
		System.out.println(Message.INPUT_MESSAGE_HOlDING_SUM);
		try {
			String input = Console.readLine();
			System.out.println();
			return new HoldingSum(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
			return getInput();
		}
	}

	public void print(HoldingSum holdingSum) {
		StringBuilder stringBuilder = new StringBuilder(Message.OUTPUT_MESSAGE_HOLDING_SUM);

		for (Coin coin : Coin.values()) {
			int coinAmount = coin.getAmount();
			int coinCount = holdingSum.getCoinCount(coin.name());
			stringBuilder.append("\n" + Message.toString(coinAmount, coinCount));
		}

		stringBuilder.append("\n");
		System.out.println(stringBuilder);
	}
}
