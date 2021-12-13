package vendingmachine.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
	private static final int ERROR_CODE = -1;
	private static final int DIVISOR_10 = 10;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_NAME_INDEX = 0;

	private static final String REGEX = "\\[[a-zA-Z0-9가-힣 _-]+,\\d{3,},\\d+]";
	private static final String DELIMITER = ",";

	private static final String ERROR_MSG = "[ERROR] ";
	private static final String INT_TYPE_ERROR_MSG = "금액은 숫자여야 합니다.";
	private static final String NEGATIVE_INT_ERROR_MSG = "금액은 0원 이상이어야 합니다.";
	private static final String NOT_DIVISIBLE_BY_10_ERROR_MSG = "금액은 10원 단위로 나누어 떨어져야 합니다.";
	private static final String ITEM_INPUT_ERROR_MSG = "상품 정보의 입력 형식이 올바르지 않습니다.";
	private static final String ITEM_DUP_ERROR_MSG = "상품명은 중복되지 않아야 합니다.";

	List<String> itemNames = new ArrayList<>();

	public int validMachineMoney(String inputAmount) {
		try {
			int amount = transferToInt(inputAmount);
			validRange(amount);
			validIsDivisibleBy10(amount);
			return amount;
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MSG + e.getMessage());
			return ERROR_CODE;
		}
	}

	private int transferToInt(String inputAmount) throws IllegalArgumentException {
		try {
			return Integer.parseInt(inputAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INT_TYPE_ERROR_MSG);
		}
	}

	private void validRange(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException(NEGATIVE_INT_ERROR_MSG);
		}
	}

	private void validIsDivisibleBy10(int amount) throws IllegalArgumentException {
		if (amount % DIVISOR_10 != 0) {
			throw new IllegalArgumentException(NOT_DIVISIBLE_BY_10_ERROR_MSG);
		}
	}

	public boolean validItemList(List<String> itemList) {
		for (String item : itemList) {
			try {
				validItemInfo(item);
			} catch (IllegalArgumentException e) {
				itemNames.clear();
				System.out.println(ERROR_MSG + e.getMessage());
				return false;
			}
		}
		return true;
	}

	private void validItemInfo(String item) throws IllegalArgumentException {
		validByRegex(item);
		String[] itemInfo = item.split(DELIMITER);
		validIsDivisibleBy10(getPriceFromItemInfo(itemInfo));
		validNameDuplication(getNameFromItemInfo(itemInfo));
	}

	private void validByRegex(String item) throws IllegalArgumentException {
		if (!Pattern.matches(REGEX, item)) {
			throw new IllegalArgumentException(ITEM_INPUT_ERROR_MSG);
		}
	}

	private int getPriceFromItemInfo(String[] itemInfo) {
		return Integer.parseInt(itemInfo[ITEM_PRICE_INDEX]);
	}

	private String getNameFromItemInfo(String[] itemInfo) {
		return itemInfo[ITEM_NAME_INDEX];
	}

	private void validNameDuplication(String itemName) throws IllegalArgumentException {
		if (itemNames.contains(itemName)) {
			throw new IllegalArgumentException(ITEM_DUP_ERROR_MSG);
		}
		itemNames.add(itemName);
	}
}
