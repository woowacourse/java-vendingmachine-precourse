package vendingmachine.view.product;

import vendingmachine.client.InputClient;
import vendingmachine.view.InputView;

public class ProductInputView extends InputView {
	public ProductInputView(InputClient inputClient) {
		super(inputClient);
	}

	@Override
	protected String getPrompt() {
		return "상품명과 가격, 수량을 입력해 주세요.";
	}
}
