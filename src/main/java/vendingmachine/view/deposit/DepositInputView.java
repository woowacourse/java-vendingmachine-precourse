package vendingmachine.view.deposit;

import vendingmachine.client.InputClient;
import vendingmachine.view.InputView;

public class DepositInputView extends InputView {

	public DepositInputView(InputClient inputClient) {
		super(inputClient);
	}

	@Override
	protected String getPrompt() {
		return "\n투입 금액을 입력해 주세요.";
	}
}
