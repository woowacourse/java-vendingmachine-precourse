package vendingmachine.view.changeback;

import vendingmachine.client.OutputClient;
import vendingmachine.view.OutputView;

public class ChangeBackOutputView extends OutputView {
	private static final String INTRO = "잔돈";

	public ChangeBackOutputView(OutputClient outputClient) {
		super(outputClient);
	}

	@Override
	protected String getIntro() {
		return INTRO;
	}
}
