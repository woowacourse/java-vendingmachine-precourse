package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.domain.Item;
import vendingmachine.util.ItemParser;
import vendingmachine.util.SystemMessage;

public class InputItemInfoView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.INPUT_ITEM_INFO);
		List<Item> items;
		try {
			items = readItems();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			show();
			return;
		}
		Application.controller.addItems(items);
	}

	private List<Item> readItems() {
		String itemListStr = Console.readLine();
		return ItemParser.parseList(itemListStr);
	}
}
