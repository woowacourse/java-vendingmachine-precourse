package vendingmachine.view.common;

import vendingmachine.client.OutputClient;
import vendingmachine.view.OutputView;

public class CommonOutputView extends OutputView {

	public CommonOutputView(OutputClient outputClient) {
		super(outputClient);
	}

	@Override
	protected String getIntro() {
		return null;
	}
}
