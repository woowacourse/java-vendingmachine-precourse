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
		List<String> stringItemsList;

		System.out.println(Message.ASK_ADD_ITEMS_MESSAGE);
		String[] itemStringList = Console.readLine().split(";");

		stringItemsList = new ArrayList<String>(Arrays.asList(itemStringList));

		removeBracket(stringItemsList);
		itemList = generateItemList(stringItemsList);

		return itemList;
	}

	public static int inputMoneyInput() {
		int inputMoney = 0;

		System.out.println(Message.ASK_INPUT_MONEY_MESSAGE);
		String stringInputMoney = Console.readLine();
		inputMoney = Integer.parseInt(stringInputMoney);

		return inputMoney;
	}

	public static String buyItemInput(){
		String buyItem = "";

		System.out.println(Message.ASK_BUY_ITEMS_MESSAGE);
		buyItem = Console.readLine();

		return buyItem;
	}

	private static void removeBracket(List<String> stringItemsList) {
		for (int i = 0; i < stringItemsList.size(); i++) {
			String stringItem = stringItemsList.get(i);
			stringItemsList.remove(i);
			stringItem = stringItem.replace("[", "");
			stringItem = stringItem.replace("]", "");
			stringItemsList.add(i, stringItem);
		}
	}

	private static ArrayList<Item> generateItemList(List<String> stringItemsList) {
		String[] eachValueOfProductArray;
		ArrayList<Item> itemArrayList = new ArrayList<Item>();
		for (int i = 0; i < stringItemsList.size(); i++) {
			eachValueOfProductArray = stringItemsList.get(i).split(",");

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
			nonNumericHoldingMoneyError(stringHoldingMoney);
			zeroHoldingMoneyError(stringHoldingMoney);
			dividedByTenHoldingMoneyError(stringHoldingMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightHoldingMoney = false;
		}
		return isRightHoldingMoney;
	}

	public static void nonNumericHoldingMoneyError(String stringHoldingMoney) {
		for (int i = 0; i < stringHoldingMoney.length(); i++) {
			if (stringHoldingMoney.charAt(i) < CHAR_NUMERIC_MIN || CHAR_NUMERIC_MAX < stringHoldingMoney.charAt(
					i)) {
				throw new IllegalArgumentException(Message.NON_NUMERIC_HOLDING_MONEY_ERROR);
			}
		}
	}

	public static void zeroHoldingMoneyError(String stringHoldingMoney) {
		if (stringHoldingMoney.equals(ZERO_HOLDING_MONEY)) {
			throw new IllegalArgumentException(Message.ZERO_HOLDING_MONEY_ERROR);
		}
	}

	public static void dividedByTenHoldingMoneyError(String stringHoldingMoney) {
		if (Integer.parseInt(stringHoldingMoney) % DIVIDE_VALUE != 0) {
			throw new IllegalArgumentException(Message.DIVIDED_BY_TEN_HOLDING_MONEY_ERROR);
		}
	}
}
