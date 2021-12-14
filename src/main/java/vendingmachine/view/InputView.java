package vendingmachine.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.utils.Message;

public class InputView {
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d+,\\d+]";

	private static final int ITEM_NAME_IDX = 0;
	private static final int ITEM_PRICE_IDX = 1;
	private static final int ITEM_STOCK_IDX = 2;
	private static final char CHAR_NUMERIC_MIN = '0';
	private static final char CHAR_NUMERIC_MAX = '9';
	private static final String ZERO_HOLDING_MONEY = "0";
	private static final int DIVIDE_VALUE = 10;

	public static int holdingMoneyInput() {
		String stringHoldingMoney = "";
		int holdingMoney = 0;
		do {
			System.out.println(Message.ASK_HOLDING_MONEY_MESSAGE);
			stringHoldingMoney = Console.readLine();
		} while (!isRightHoldingMoney(stringHoldingMoney));

		holdingMoney = Integer.parseInt(stringHoldingMoney);
		System.out.println();
		return holdingMoney;
	}

	public static List<Item> holdingItemsInput() {
		List<Item> itemList;
		String itemString = "";
		String[] itemStringArray;
		do {
			System.out.println(Message.ASK_ADD_ITEMS_MESSAGE);
			itemString = Console.readLine();
			itemStringArray = itemString.split(";");
		} while (!isRightItemInput(itemStringArray));

		removeBracket(itemStringArray);
		itemList = new ArrayList<Item>(generateItemList(itemStringArray));
		System.out.println();
		return itemList;
	}

	public static int inputMoneyInput() {
		int inputMoney = 0;
		String stringInputMoney = "";
		do {
			System.out.println(Message.ASK_INPUT_MONEY_MESSAGE);
			stringInputMoney = Console.readLine();
		} while (!isRightInputMoney(stringInputMoney));

		System.out.println();
		inputMoney = Integer.parseInt(stringInputMoney);

		return inputMoney;
	}

	public static String buyItemInput(List<Item> holdingItemList, int inputMoney) {
		String buyItem = "";
		do {
			System.out.println(Message.ASK_BUY_ITEMS_MESSAGE);
			buyItem = Console.readLine();
		} while(!isPurchasableItem(buyItem, holdingItemList, inputMoney));
		System.out.println();
		return buyItem;
	}

	private static void removeBracket(String[] stringItemsArray) {
		for (int i = 0; i < stringItemsArray.length; i++) {
			stringItemsArray[i] = stringItemsArray[i].replace("[", "");
			stringItemsArray[i] = stringItemsArray[i].replace("]", "");
		}
	}

	private static List<Item> generateItemList(String[] stringItemsArray) {
		String[] eachValueOfProductArray;
		List<Item> itemArrayList = new ArrayList<Item>();
		for (int i = 0; i < stringItemsArray.length; i++) {
			eachValueOfProductArray = stringItemsArray[i].split(",");

			String name = eachValueOfProductArray[ITEM_NAME_IDX];
			int price = Integer.parseInt(eachValueOfProductArray[ITEM_PRICE_IDX]);
			int stock = Integer.parseInt(eachValueOfProductArray[ITEM_STOCK_IDX]);

			Item item = new Item(name, price, stock);
			itemArrayList.add(item);
		}
		return itemArrayList;
	}

	private static boolean isRightHoldingMoney(String stringHoldingMoney) {
		boolean isRightHoldingMoney = true;
		try {
			nonNumericError(stringHoldingMoney);
			zeroNumericError(stringHoldingMoney);
			dividedByTenMoneyError(stringHoldingMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightHoldingMoney = false;
		}
		return isRightHoldingMoney;
	}

	private static boolean isRightInputMoney(String stringInputMoney) {
		boolean isRightInputMoney = true;
		try {
			nonNumericError(stringInputMoney);
			zeroNumericError(stringInputMoney);
			dividedByTenMoneyError(stringInputMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightInputMoney = false;
		}
		return isRightInputMoney;
	}

	private static boolean isRightItemInput(String[] itemStringArray) {
		boolean isRightItemInput = true;
		try {
			wrongRegexMatchError(itemStringArray);
			duplicatedItemNameError(itemStringArray);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightItemInput = false;
		}
		return isRightItemInput;
	}

	public static boolean isPurchasableItem(String buyItem, List<Item> holdingItemList, int inputMoney) {
		boolean isPurchasableItem = true;
		try {
			nonExistItemError(buyItem, holdingItemList);
			nonEnoughMoneyError(buyItem, holdingItemList, inputMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isPurchasableItem = false;
		}
		return isPurchasableItem;
	}

	public static void nonNumericError(String stringHoldingMoney) {
		for (int i = 0; i < stringHoldingMoney.length(); i++) {
			if (stringHoldingMoney.charAt(i) < CHAR_NUMERIC_MIN || CHAR_NUMERIC_MAX < stringHoldingMoney.charAt(
					i)) {
				throw new IllegalArgumentException(Message.NON_NUMERIC_ERROR);
			}
		}
	}

	public static void zeroNumericError(String stringHoldingMoney) {
		if (stringHoldingMoney.equals(ZERO_HOLDING_MONEY)) {
			throw new IllegalArgumentException(Message.ZERO_NUMERIC_ERROR);
		}
	}

	public static void dividedByTenMoneyError(String stringMoney) {
		if (Integer.parseInt(stringMoney) % DIVIDE_VALUE != 0) {
			throw new IllegalArgumentException(Message.DIVIDED_BY_TEN_HOLDING_MONEY_ERROR);
		}
	}

	private static void duplicatedItemNameError(String[] itemStringArray) {
		Set<String> itemNames = new HashSet<String>();
		removeBracket(itemStringArray);
		int itemCount = itemStringArray.length;
		for (int i = 0; i < itemCount; i++) {
			itemNames.add(itemStringArray[i].split(",")[0]);
		}
		if (itemCount != itemNames.size()) {
			throw new IllegalArgumentException(Message.DUPLICATED_NAME_ITEM_ERROR);
		}
	}

	private static void wrongRegexMatchError(String[] itemStringArray) {
		for (int i = 0; i < itemStringArray.length; i++) {
			if (!Pattern.matches(REGEX, itemStringArray[i])) {
				throw new IllegalArgumentException(Message.WRONG_REGEX_MATCH_ERROR);
			}
		}
	}

	public static void nonExistItemError(String buyItem, List<Item> holdingItemList) {
		boolean isExistedItem = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem)) {
				isExistedItem = true;
			}
		}
		if (isExistedItem == false) {
			throw new IllegalArgumentException(Message.NON_EXIST_ITEM_ERROR);
		}
	}

	public static void nonEnoughMoneyError(String buyItem, List<Item> holdingItemList, int inputMoney) {
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem) && holdingItemList.get(i).getPrice() > inputMoney) {
				throw new IllegalArgumentException(Message.NON_ENOUGH_MONEY_ERROR);
			}
		}
	}
}
