package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.view.ChangeReturnView;
import vendingmachine.view.MoneyInputView;
import vendingmachine.view.ProductInitializerView;
import vendingmachine.view.ProductPurchaseView;
import vendingmachine.view.RetentionMoneyInitializerView;
import vendingmachine.view.VendingMachineView;

public class Application {
	private static final VendingMachineController controller = new VendingMachineController();

	public static void main(String[] args) {
		showView(new RetentionMoneyInitializerView(controller));
		showView(new ProductInitializerView(controller));
		showView(new MoneyInputView(controller));
		showView(new ProductPurchaseView(controller));
		showView(new ChangeReturnView(controller));
	}

	public static void showView(VendingMachineView view) {
		while (view.isShow()) {
			view.show();
		}
	}
}
