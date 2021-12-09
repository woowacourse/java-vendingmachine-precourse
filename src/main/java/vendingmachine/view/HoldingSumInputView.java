package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.model.Coin;
import vendingmachine.model.HoldingSum;

public class HoldingSumInputView {

	public HoldingSum getInput() {
		System.out.println(Message.INPUT_MESSAGE_HOlDING_SUM);
		HoldingSum holdingSum = new HoldingSum();
		try {
			String input = Console.readLine();
			holdingSum.set(input);
		} catch (Exception e) {
			System.out.println(Message.ERROR + e.getMessage());
			return getInput();
		}
		return holdingSum;
	}

	public void print(HoldingSum holdingSum) {
		StringBuilder stringBuilder = new StringBuilder(Message.OUTPUT_MESSAGE_HOLDING_SUM);

		for (Coin coin : Coin.values()) {
			stringBuilder.append("\n" + coin.getAmount() + "원 - " + holdingSum.getCoinCount(coin.name()) + "개");
		}

		System.out.println(stringBuilder);
	}
}
