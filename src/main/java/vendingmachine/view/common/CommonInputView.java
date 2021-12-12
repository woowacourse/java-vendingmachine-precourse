package vendingmachine.view.common;

import vendingmachine.client.InputClient;
import vendingmachine.view.InputView;

public class CommonInputView extends InputView {

	public CommonInputView(InputClient inputClient) {
		super(inputClient);
	}

	@Override
	protected String getPrompt() {
		return null;
	}
}
