package vendingmachine.config;

import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;
import vendingmachine.view.changesafe.ChangeSafeInputView;
import vendingmachine.view.changesafe.ChangeSafeOutputView;
import vendingmachine.view.common.CommonErrorView;
import vendingmachine.view.common.CommonOutputView;
import vendingmachine.view.deposit.DepositInputView;
import vendingmachine.view.product.ProductInputView;
import vendingmachine.view.purchase.PurchaseInputView;
import vendingmachine.view.purchase.PurchaseOutputView;

public class ViewConfig {

	public static ErrorView getCommonErrorView() {
		return new CommonErrorView(ClientConfig.getErrorClient());
	}

	public static OutputView getCommonOutputView() {
		return new CommonOutputView(ClientConfig.getOutputClient());
	}

	public static InputView getChangeSafeInputView() {
		return new ChangeSafeInputView(ClientConfig.getInputClient());
	}

	public static OutputView getChangeSafeOutputView() {
		return new ChangeSafeOutputView(ClientConfig.getOutputClient());
	}

	public static InputView getProductInputView() {
		return new ProductInputView(ClientConfig.getInputClient());
	}

	public static InputView getDepositInputView() {
		return new DepositInputView(ClientConfig.getInputClient());
	}

	public static InputView getPurchaseInputView() {
		return new PurchaseInputView(ClientConfig.getInputClient());
	}

	public static OutputView getPurchaseOutputView() {
		return new PurchaseOutputView(ClientConfig.getOutputClient());
	}
}
