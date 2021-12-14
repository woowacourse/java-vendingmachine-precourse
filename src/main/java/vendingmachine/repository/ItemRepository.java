package vendingmachine.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.view.InputView;

public class ItemRepository {

	private static List<Item> items;

	public static void addItems(List<Item> itemsArgument) {
		items = itemsArgument;
	}

	public static int buyItems(int moneyToBuy) {
		while (canBuy(moneyToBuy)) {
			Item item = InputView.printBuying(moneyToBuy);
			moneyToBuy -= item.getPrice();
		}
		return moneyToBuy;
	}

	private static boolean canBuy(int moneyToBuy) {
		return moneyToBuy >= itemMinPrice();
	}

	private static int itemMinPrice() {
		return items.stream()
			.mapToInt(item -> item.getPrice())
			.min()
			.getAsInt();
	}

	public static boolean existItemByName(String input) {
		return items.stream()
			.anyMatch(item->item.equalName(input));
	}

	public static Item findItemByName(String input) {
		return items.stream()
			.filter(item -> item.equalName(input))
			.findAny()
			.get();
	}

}
