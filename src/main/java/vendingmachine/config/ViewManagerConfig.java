package vendingmachine.config;

import javax.swing.text.View;

import vendingmachine.view.ViewManager;

public class ViewManagerConfig {
	public static ViewManager getChangeSafeViewManager() {
		return new ViewManager(
			ViewConfig.getChangeSafeInputView(),
			ViewConfig.getChangeSafeOutputView(),
			ViewConfig.getCommonErrorView()
		);
	}

	public static ViewManager getProductViewManager() {
		return new ViewManager(
			ViewConfig.getProductInputView(),
			ViewConfig.getCommonOutputView(),
			ViewConfig.getCommonErrorView()
		);
	}

	public static ViewManager getDepositViewManager() {
		return new ViewManager(
			ViewConfig.getDepositInputView(),
			ViewConfig.getCommonOutputView(),
			ViewConfig.getCommonErrorView()
		);
	}

	public static ViewManager getPurchaseViewManager() {
		return new ViewManager(
			ViewConfig.getPurchaseInputView(),
			ViewConfig.getPurchaseOutputView(),
			ViewConfig.getCommonErrorView()
		);
	}

	public static ViewManager getChangeBackViewManager() {
		return new ViewManager(
			ViewConfig.getCommonInputView(),
			ViewConfig.getChangeBackOutputView(),
			ViewConfig.getCommonErrorView()
		);
	}
}
