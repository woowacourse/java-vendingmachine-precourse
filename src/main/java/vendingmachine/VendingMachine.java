package vendingmachine;

import vendingmachine.billing.BillingController;
import vendingmachine.billing.Payments;
import vendingmachine.product.ProductController;
import vendingmachine.product.ProductStorage;
import vendingmachine.trade.Trade;

public class VendingMachine {
	private BillingController billingController;
	private ProductController productController;

	public VendingMachine() {
		billingController = new BillingController();
		productController = new ProductController();
	}

	public void useService() {
		billingController.readyToChanges();
		ProductStorage productStorage = productController.readyToProductStorage();

		Payments payments = billingController.insertMoney();
		
		Trade trade = new Trade(productStorage, payments);
		trade.repeat();

		billingController.returnChangeCoins();
	}
}
