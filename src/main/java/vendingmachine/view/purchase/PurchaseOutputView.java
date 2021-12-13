package vendingmachine.view.purchase;

import vendingmachine.client.OutputClient;
import vendingmachine.view.OutputView;
import vendingmachine.view.common.CommonOutputView;

public class PurchaseOutputView extends CommonOutputView {

	private static final String PREFIX = "투입 금액: ";

	public PurchaseOutputView(OutputClient outputClient) {
		super(outputClient);
	}

	@Override
	public void output(String msg) {
		super.output(PREFIX + msg);
	}
}
