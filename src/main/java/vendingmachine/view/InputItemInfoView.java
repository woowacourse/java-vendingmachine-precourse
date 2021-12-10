package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Application;
import vendingmachine.controller.ViewMappingKey;
import vendingmachine.domain.Item;
import vendingmachine.util.ItemParser;
import vendingmachine.util.PublicConst;
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
		Application.controller.view(ViewMappingKey.INPUT_MONEY);
	}

	private List<Item> readItems() {
		String itemListStr = Console.readLine().replaceAll(PublicConst.BLANK_REGEX, PublicConst.EMPTY_STRING);
		return ItemParser.parseList(itemListStr);
	}
}
