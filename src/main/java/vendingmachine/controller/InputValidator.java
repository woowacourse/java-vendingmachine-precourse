package vendingmachine.controller;

import static vendingmachine.Constant.*;

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

	public static void checkValidRange(int input, int range) {
		if (input < range) {
			throw new IllegalArgumentException();
		}
	}

	public static int checkValidItem(List<Item> itemList, String buyingItem) {
		int index = 0;
		for (Item item : itemList) {
			if ((item.name).equals(buyingItem)) {
				return index;
			}
			index++;
		}
		throw new IllegalArgumentException();
	}

	public static boolean checkValidFormat(String itemInform) {
		String regex = "\\[[a-zA-z0-9가-힣]+,\\d{3,},\\d+]";
		if (itemInform.matches(regex)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	public static boolean checkValidSplitFormat(String[] itemInform) {
		int price = isNumber(itemInform[ITEM_PRICE_INDEX]);
		int count = isNumber(itemInform[ITEM_COUNT_INDEX]);
		if (price % 10 != 0 || count < 1) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public static void checkDuplicateName(List<String> itemNameList, String name) {
		if (itemNameList.contains(name)) {
			throw new IllegalArgumentException();
		}
		itemNameList.add(name);
	}
}
