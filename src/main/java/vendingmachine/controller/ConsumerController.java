package vendingmachine.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.util.ItemValidator;
import vendingmachine.util.MoneyValidator;

public class ConsumerController {
	public static int getInputMoney() {
		String inputString = Console.readLine();
		try {
			MoneyValidator.validate(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getInputMoney();
		}
		return Integer.parseInt(inputString);
	}

	public static Item getPurchaseItemName(List<Item> itemList) {
		Item item;
		String inputString = Console.readLine();
		try {
			item = ItemValidator.validateAvailability(itemList, inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getPurchaseItemName(itemList);
		}
		return item;
	}
}
