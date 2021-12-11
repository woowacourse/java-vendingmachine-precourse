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

	public static boolean checkEmptyItemList(List<Item> itemsList) {
		if (itemsList.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean checkBuyingPossible(List<Item> itemList, int inputMoney) {
		for (Item item : itemList) {
			if (inputMoney >= item.price) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkExcessMoney(int inputMoney, int itemPrice) {
		if (inputMoney - itemPrice >= 0) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
