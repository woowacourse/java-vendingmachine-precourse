package vendingmachine.domain;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.utils.Parser.parsingItemInfo;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.utils.Validator;

public class Items {
	private final List<Item> forSaleItems = new ArrayList<>();

	public Items() {
	}

	public Item findItemByName(String name) {
		return forSaleItems.stream()
				.filter(i -> i.getName().equals(name))
				.findFirst().orElse(ELEMENT_NOT_FOUNDED);
	}

	public List<Item> getForSaleItemsList() {
		return forSaleItems;
	}

	public Items createForSaleItems(String[] itemsInfo) {
		for (String info : itemsInfo) {
			String[] parsedItemInfo = parsingItemInfo(info);
			Item validItem = Validator.validateItemInfo(parsedItemInfo, forSaleItems);
			forSaleItems.add(validItem);
		}

		return this;
	}
}
