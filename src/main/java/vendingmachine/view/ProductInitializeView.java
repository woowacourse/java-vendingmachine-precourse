package vendingmachine.view;

public class ProductInitializeView extends VendingMachineView {
	@Override
	public void show() {
		String products = inputProcessor.readProductComposition();
		controller.addProductList(products);
	}
}
