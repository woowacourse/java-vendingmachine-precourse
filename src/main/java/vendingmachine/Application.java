package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.view.ChangeReturnView;
import vendingmachine.view.MoneyInputView;
import vendingmachine.view.ProductInitializeView;
import vendingmachine.view.ProductPurchaseView;
import vendingmachine.view.RetentionMoneyInitializeView;
import vendingmachine.view.VendingMachineView;

public class Application {
	private static final VendingMachineController controller = new VendingMachineController();

	public static void main(String[] args) {
		showView(new RetentionMoneyInitializeView(controller));
		showView(new ProductInitializeView(controller));
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
