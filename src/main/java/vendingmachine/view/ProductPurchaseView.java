package vendingmachine.view;

import vendingmachine.Money;

public class ProductPurchaseView extends VendingMachineView {
	@Override
	public void show() {
		Money insertMoney = controller.getInsertMoney();
		outputProcessor.printInsertMoney(insertMoney);
		String productName = inputProcessor.readProductName();
		controller.purchaseProduct(productName);
	}
}
