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

	public static boolean checkValidFormat(String itemInform) {
		String regex = "\\[[a-zA-z0-9가-힣]+,\\d{3,},\\d+]";
		if (itemInform.matches(regex)) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	public static boolean checkValidSplitFormat(String[] itemList) {
		int price = isNumber(itemList[InputController.ITEM_PRICE_INDEX]);
		int count = isNumber(itemList[InputController.ITEM_COUNT_INDEX]);
		if (price % 10 != 0 || count < 1){
			throw new IllegalArgumentException();
		}
		return true;
	}
}
