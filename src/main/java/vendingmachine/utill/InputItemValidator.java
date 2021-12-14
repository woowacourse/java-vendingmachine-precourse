package vendingmachine.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputItemValidator {
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣 _-]+,\\d{3,},\\d+]";

	List<String> itemNames = new ArrayList<>();

	public boolean validateItemList(List<String> itemList) {
		try {
			validateItems(itemList);
		} catch (IllegalArgumentException e) {
			itemNames.clear();
			System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
			return false;
		}
		return true;
	}

	private void validateItems(List<String> itemList) throws IllegalArgumentException {
		for (String item : itemList) {
			validateByRegex(item);
			String[] itemInfo = splitItem(item);
			InputMoneyValidator.validateIsDivisibleBy10(Integer.parseInt(itemInfo[ItemConst.PRICE_INDEX]));
			validateNameDuplication(itemInfo[ItemConst.NAME_INDEX]);
		}
	}

	private String[] splitItem(String item) {
		item = item.replace(ItemConst.OPEN_BRACKET, "");
		return item.split(ItemConst.DELIMITER);
	}

	private void validateByRegex(String item) throws IllegalArgumentException {
		if (!Pattern.matches(REGEX, item)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_INPUT_ERROR_MSG);
		}
	}

	private void validateNameDuplication(String itemName) throws IllegalArgumentException {
		if (itemNames.contains(itemName)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_DUP_ERROR_MSG);
		}
		itemNames.add(itemName);
	}

	public boolean validateInputItemName(List<String> itemList, String itemName) {
		try {
			isExistInItemList(itemList, itemName);
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMsgConst.ERROR_MSG + e.getMessage());
			return false;
		}
		return true;
	}

	private void isExistInItemList(List<String> itemList, String itemName) throws IllegalArgumentException {
		if (!itemList.contains(itemName)) {
			throw new IllegalArgumentException(ErrorMsgConst.ITEM_NOT_EXIST_ERROR_MSG);
		}
	}
}
