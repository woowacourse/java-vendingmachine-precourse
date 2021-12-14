package vendingmachine.domain;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.utils.Parser.parsingItemInfo;

import java.util.ArrayList;
import java.util.List;

public class Items {
	private final List<Item> forSaleItems = new ArrayList<>();

	public Item findItemByName(String name) {
		return forSaleItems.stream()
				.filter(i -> i.isSameName(name))
				.findFirst().orElse(ELEMENT_NOT_FOUNDED);
	}

	public List<Item> getForSaleItemsList() {
		return forSaleItems;
	}

	public boolean checkCanPurchaseAtLeastOneItem(int userMoney) {
		return forSaleItems.stream().anyMatch(item -> item.canPurchase(userMoney));
	}

	public Items createForSaleItems(String[] itemsInfo) {
		for (String itemInfo : itemsInfo) {
			String[] parsedItemInfo = parsingItemInfo(itemInfo);
			Item registeredItem = Item.registerItem(parsedItemInfo, forSaleItems);

			forSaleItems.add(registeredItem);
		}

		return this;
	}
}
