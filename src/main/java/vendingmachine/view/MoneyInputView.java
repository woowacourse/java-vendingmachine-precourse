package vendingmachine.view;

public class MoneyInputView extends VendingMachineView {
	@Override
	public void show() {
		String insertMoney = inputProcessor.readInsertMoney();
		controller.addInsertMoney(insertMoney);
	}
}
