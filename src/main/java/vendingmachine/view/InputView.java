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

	public int holdingMoneyInput() {
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

	public List<Item> holdingItemsInput() {
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

	public int inputMoneyInput() {
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

	public String buyItemInput(List<Item> holdingItemList, int inputMoney) {
		String buyItem = "";
		do {
			System.out.println(Message.ASK_BUY_ITEMS_MESSAGE);
			buyItem = Console.readLine();
		} while(!isPurchasableItem(buyItem, holdingItemList, inputMoney));
		System.out.println();
		return buyItem;
	}

	private void removeBracket(String[] stringItemsArray) {
		for (int i = 0; i < stringItemsArray.length; i++) {
			stringItemsArray[i] = stringItemsArray[i].replace("[", "");
			stringItemsArray[i] = stringItemsArray[i].replace("]", "");
		}
	}

	private List<Item> generateItemList(String[] stringItemsArray) {
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

	private boolean isRightHoldingMoney(String stringHoldingMoney) {
		boolean isRightHoldingMoney = true;
		try {
			nonNumericValidate(stringHoldingMoney);
			zeroNumericValidate(stringHoldingMoney);
			dividedByTenMoneyValidate(stringHoldingMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightHoldingMoney = false;
		}
		return isRightHoldingMoney;
	}

	private boolean isRightInputMoney(String stringInputMoney) {
		boolean isRightInputMoney = true;
		try {
			nonNumericValidate(stringInputMoney);
			zeroNumericValidate(stringInputMoney);
			dividedByTenMoneyValidate(stringInputMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightInputMoney = false;
		}
		return isRightInputMoney;
	}

	private boolean isRightItemInput(String[] itemStringArray) {
		boolean isRightItemInput = true;
		try {
			wrongRegexMatchValidate(itemStringArray);
			duplicatedItemNameValidate(itemStringArray);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightItemInput = false;
		}
		return isRightItemInput;
	}

	public boolean isPurchasableItem(String buyItem, List<Item> holdingItemList, int inputMoney) {
		boolean isPurchasableItem = true;
		try {
			nonExistItemValidate(buyItem, holdingItemList);
			nonEnoughMoneyValidate(buyItem, holdingItemList, inputMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isPurchasableItem = false;
		}
		return isPurchasableItem;
	}

	public void nonNumericValidate(String stringHoldingMoney) {
		for (int i = 0; i < stringHoldingMoney.length(); i++) {
			if (stringHoldingMoney.charAt(i) < CHAR_NUMERIC_MIN || CHAR_NUMERIC_MAX < stringHoldingMoney.charAt(
					i)) {
				throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
			}
		}
	}

	public void zeroNumericValidate(String stringHoldingMoney) {
		if (stringHoldingMoney.equals(ZERO_HOLDING_MONEY)) {
			throw new IllegalArgumentException("[ERROR] 금액은 0이 아닌 양의 정수를 입력하셔야 합니다.");
		}
	}

	public void dividedByTenMoneyValidate(String stringMoney) {
		if (Integer.parseInt(stringMoney) % DIVIDE_VALUE != 0) {
			throw new IllegalArgumentException("[ERROR] 보유 금액은 10으로 나누어 떨어져야 합니다.");
		}
	}

	private void duplicatedItemNameValidate(String[] itemStringArray) {
		Set<String> itemNames = new HashSet<String>();
		removeBracket(itemStringArray);
		int itemCount = itemStringArray.length;
		for (int i = 0; i < itemCount; i++) {
			itemNames.add(itemStringArray[i].split(",")[0]);
		}
		if (itemCount != itemNames.size()) {
			throw new IllegalArgumentException("[ERROR] 중복된 상품 이름은 허용하지 않습니다.");
		}
	}

	private void wrongRegexMatchValidate(String[] itemStringArray) {
		for (int i = 0; i < itemStringArray.length; i++) {
			if (!Pattern.matches(REGEX, itemStringArray[i])) {
				throw new IllegalArgumentException("[ERROR] 올바른 형식으로 입력해주세요.");
			}
		}
	}

	public void nonExistItemValidate(String buyItem, List<Item> holdingItemList) {
		boolean isExistedItem = false;
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem)) {
				isExistedItem = true;
			}
		}
		if (isExistedItem == false) {
			throw new IllegalArgumentException("[ERROR] 존재하지 않은 상품은 구매할 수 없습니다.");
		}
	}

	public void nonEnoughMoneyValidate(String buyItem, List<Item> holdingItemList, int inputMoney) {
		for (int i = 0; i < holdingItemList.size(); i++) {
			if (holdingItemList.get(i).getName().equals(buyItem) && holdingItemList.get(i).getPrice() > inputMoney) {
				throw new IllegalArgumentException("[ERROR] 보유 금액보다 상품 가격이 더 비쌉니다.");
			}
		}
	}
}
