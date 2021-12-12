package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;

public class ProductInitializeView extends VendingMachineView {
	public ProductInitializeView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String products = inputProcessor.readProductComposition();
		outputProcessor.printLine();
		try {
			controller.addProductList(products);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
