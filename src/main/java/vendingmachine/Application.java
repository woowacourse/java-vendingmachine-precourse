package vendingmachine;

import vendingmachine.model.Items;
import vendingmachine.model.UserMoney;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.ResultView;

public class Application {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
		int remains = InputView.GetRemains();
		ResultView.printRemains(machine.generateRemainCoins(remains));
		Items items = getItems();
		UserMoney userMoney = new UserMoney(InputView.GetUserMoney());
		while (!machine.canNotBuyAnything(userMoney, items)) {
			machine.buyItem(InputView.GetItemToBuy(userMoney), items, userMoney);
		}
		ResultView.printRemainMoney(userMoney);
		ResultView.printChange(machine.returnChange(userMoney));
	}

	public static Items getItems() {
		InputView.printGetItemStatus();
		String[] itemStatuses = InputView.getItemStatuses().split(";");
		Items items = new Items();
		for (String itemStatus : itemStatuses) {
			items.addItem(itemStatus);
		}
		return items;
	}
}
