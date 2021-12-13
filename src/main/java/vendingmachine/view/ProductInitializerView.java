package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;

public class ProductInitializerView extends VendingMachineView {
	public ProductInitializerView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String products = inputProcessor.readProductComposition();
		outputProcessor.printLine();
		try {
			controller.addProducts(products);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
