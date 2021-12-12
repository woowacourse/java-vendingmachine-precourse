package vendingmachine.view.purchase;

import vendingmachine.client.InputClient;
import vendingmachine.view.InputView;

public class PurchaseInputView extends InputView {

	public PurchaseInputView(InputClient inputClient) {
		super(inputClient);
	}

	@Override
	protected String getPrompt() {
		return "구매할 상품명을 입력해 주세요.";
	}
}
