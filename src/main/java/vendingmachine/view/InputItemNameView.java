package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.controller.ViewMappingKey;
import vendingmachine.domain.Item;
import vendingmachine.util.PublicConst;
import vendingmachine.util.SystemMessage;

public class InputItemNameView implements View {

	@Override
	public void flow() {
		int money = getMoney();
		if (!canPurchase(money)) {
			goReturnChangesView();
			return;
		}
		printMoneyAndMessage(money);
		purchase(money);
		reshow();
	}

	private void printMoneyAndMessage(int money) {
		System.out.println();
		List<String> itemStrings = Application.controller.getItemStringsByMoney(money);
		System.out.println(SystemMessage.CAN_PURCHASE_LIST + String.join(PublicConst.ITEM_SEPARATOR, itemStrings));
		System.out.println(SystemMessage.SHOW_INPUT_MONEY + money + PublicConst.MONETARY_UNIT);
		System.out.println(SystemMessage.INPUT_ITEM_NAME);
	}

	private void purchase(int money) {
		String itemName = readItemName();
		Item item;
		try {
			item = Application.controller.searchItem(itemName, money);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		Application.controller.purchase(item);
	}

	private String readItemName() {
		return Console.readLine().replaceAll(PublicConst.BLANK_REGEX, PublicConst.EMPTY_STRING);
	}

	private boolean canPurchase(int money) {
		return Application.controller.canPurchaseByMoney(money);
	}

	private int getMoney() {
		return Application.controller.getMoney();
	}

	private void goReturnChangesView() {
		Application.controller.view(ViewMappingKey.RETURN_CHANGES);
	}

	private void reshow() {
		Application.controller.view(ViewMappingKey.INPUT_ITEM_NAME);
	}
}
