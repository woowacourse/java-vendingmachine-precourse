package vendingmachine.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.util.ItemParser;
import vendingmachine.util.SystemMessage;

public class InputItemInfoView implements View {
	@Override
	public void show() {
		System.out.println(SystemMessage.INPUT_ITEM_INFO);
		List<Item> items = readItems();
	}

	private List<Item> readItems() {
		String itemListStr = Console.readLine();
		return ItemParser.parseList(itemListStr);
	}
}
