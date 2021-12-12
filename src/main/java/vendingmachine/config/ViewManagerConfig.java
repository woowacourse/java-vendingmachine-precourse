package vendingmachine.config;

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
}
