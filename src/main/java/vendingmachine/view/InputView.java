package vendingmachine.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.utils.Message;

public class InputView {
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

	public static ArrayList<Item> holdingItemsInput() {
		ArrayList<Item> itemList;
		//[진로,2500,3];[카스,1000,2] -> [ [진로,2500,3], [카스,1000,2] ]

		System.out.println(Message.ASK_ADD_ITEMS_MESSAGE);
		String[] itemStringArray = Console.readLine().split(";");
		removeBracket(itemStringArray);
		itemList = generateItemList(itemStringArray);
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

	public static String buyItemInput() {
		String buyItem = "";

		System.out.println(Message.ASK_BUY_ITEMS_MESSAGE);
		buyItem = Console.readLine();
		System.out.println();
		return buyItem;
	}

	private static void removeBracket(String[] stringItemsArray) {
		for (int i = 0; i < stringItemsArray.length; i++) {
			stringItemsArray[i] = stringItemsArray[i].replace("[", "");
			stringItemsArray[i] = stringItemsArray[i].replace("]", "");
		}
	}

	private static ArrayList<Item> generateItemList(String[] stringItemsArray) {
		String[] eachValueOfProductArray;
		ArrayList<Item> itemArrayList = new ArrayList<Item>();
		for (int i = 0; i < stringItemsArray.length; i++) {
			eachValueOfProductArray = stringItemsArray[i].split(",");

			String name = eachValueOfProductArray[0];
			int price = Integer.parseInt(eachValueOfProductArray[1]);
			int stock = Integer.parseInt(eachValueOfProductArray[2]);

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

	// private static boolean isRightHoldingItem(List<String> stringItemList) {
	// 	boolean isRightHoldingItem = true;
	//
	// 	try {
	//
	// 	}
	// }

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
}
