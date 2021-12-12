package vendingmachine.view;

import vendingmachine.VendingMachineController;

public class ProductInitializeView extends VendingMachineView {
	public ProductInitializeView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String products = inputProcessor.readProductComposition();
		try {
			controller.addProductList(products);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
