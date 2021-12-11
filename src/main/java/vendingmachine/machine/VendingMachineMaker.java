package vendingmachine.machine;

import vendingmachine.changes.ChangesController;
import vendingmachine.product.ProductController;

public class VendingMachineMaker {
	private ChangesController changesController;
	private ProductController productController;

	public VendingMachineMaker() {
		this.changesController = new ChangesController();
		this.productController = new ProductController();
	}

	public VendingMachine readyToService() {
		return new VendingMachine(changesController.readyToChanges(), productController.readyToProductStorage());
	}
}
