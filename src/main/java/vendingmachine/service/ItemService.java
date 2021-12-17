package vendingmachine.service;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.repository.ItemRepository;
import vendingmachine.util.Symbol;

public class ItemService {
	private final ItemRepository itemRepository;

	public ItemService() {
		this.itemRepository = new ItemRepository();
	}

	public void saveItem(String itemInfo) {
		List<String> listOfInfo = Arrays.asList(decodeInput(itemInfo));
		listOfInfo.stream().map(s -> s.split(","))
			.forEach(s -> itemRepository.addItem(s[0], new Item(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]))));
	}

	private String[] decodeInput(String itemInfo) {
		itemInfo = itemInfo.replaceAll(Symbol.OPEN_BRACES, Symbol.NULL).replaceAll(Symbol.CLOSE_BRACES, Symbol.NULL);
		return itemInfo.split(Symbol.SEMICOLON);
	}

	public boolean canBuyAnything(int payMoney) {
		if (payMoney < itemRepository.getMinItemPrice() || itemRepository.isAllItemSoldOut()) {
			return false;
		}
		return true;
	}

	public int buyItem(int payMoney, String itemName) {
		if (!itemRepository.isItemSoldOut(itemName)) {
			return payMoney - itemRepository.buyItemAndGetPrice(itemName);
		}
		return payMoney;
	}
}
