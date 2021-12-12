package vendingmachine.view;

import vendingmachine.controller.VendingMachineController;

public class MoneyInputView extends VendingMachineView {
	public MoneyInputView(VendingMachineController controller) {
		super(controller);
	}

	@Override
	public void show() {
		String insertMoney = inputProcessor.readInsertMoney();
		outputProcessor.printLine();
		try {
			controller.addInsertMoney(insertMoney);
			hide();
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
