package vendingmachine.view.changesafe;

import vendingmachine.client.OutputClient;
import vendingmachine.view.OutputView;

public class ChangeSafeOutputView extends OutputView {

	public ChangeSafeOutputView(OutputClient outputClient) {
		super(outputClient);
	}

	@Override
	protected String getIntro() {
		return "\n자판기가 보유한 동전";
	}
}
