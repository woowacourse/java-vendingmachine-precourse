package vendingmachine;

import vendingmachine.billing.BillingController;
import vendingmachine.billing.Payments;
import vendingmachine.product.ProductController;
import vendingmachine.product.ProductStorage;
import vendingmachine.trade.Trade;

public class Application {
	public static void main(String[] args) {
		BillingController billingController = new BillingController();
		ProductController productController = new ProductController();
		billingController.readyToChanges();
		ProductStorage productStorage = productController.readyToProductStorage();

		Payments payments = billingController.insertMoney();
		Trade trade = new Trade(productStorage, payments);
		trade.repeat();

		billingController.returnChangeCoins();
	}
}
