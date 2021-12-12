package vendingmachine.view.changesafe;

import vendingmachine.client.InputClient;
import vendingmachine.view.InputView;

public class ChangeSafeInputView extends InputView {
	public ChangeSafeInputView(InputClient inputClient) {
		super(inputClient);
	}

	@Override
	protected String getPrompt() {
		return "자판기가 보유하고 있는 금액을 입력해 주세요.";
	}
}
