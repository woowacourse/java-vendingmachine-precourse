package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Item;

public class InputValidator {
	public static int isNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		return Integer.parseInt(input);
	}

	public static boolean checkValidItem(List<Item> itemList, String buyingItem) {
		for (Item item : itemList) {
			if ((item.name).equals(buyingItem)) {
				return true;
			}
		}
		throw new IllegalArgumentException();
	}
}
