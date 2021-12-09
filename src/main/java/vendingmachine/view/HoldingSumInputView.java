package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Message;
import vendingmachine.domain.HoldingSum;

public class HoldingSumInputView implements InputView {

	HoldingSum holdingSum;

	public HoldingSumInputView() {
		holdingSum = new HoldingSum();
	}

	public HoldingSum getInput() {
		return this.holdingSum;
	}

	@Override
	public void setInput() {
		System.out.println(Message.INPUT_MESSAGE_HOlDING_SUM);
		try {
			String input = Console.readLine();
			holdingSum.set(input);
		} catch (Exception e) {
			System.out.println(Message.ERROR + e.getMessage());
			setInput();
		}
	}
}
