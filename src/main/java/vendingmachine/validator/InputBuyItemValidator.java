package vendingmachine.validator;

import java.util.HashMap;

import vendingmachine.domain.Item;

public class InputBuyItemValidator {
	private final static String EXIST_ERROR_MESSAGE = "[ERROR] 구매하려는 상품이 존재하지 않습니다.";
	private final static String NUMBER_ERROR_MESSAGE = "[ERROR] 구매하려는 상품의 수량이 부족합니다.";
	private final static int MIN_NUMBER = 1;

	private InputBuyItemValidator() {
	}

	public static boolean isValidated(String inputBuyItem, HashMap<String, Item> items) {
		try {
			checkExist(inputBuyItem, items);
			checkNumber(inputBuyItem, items);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void checkExist(String inputBuyItem, HashMap<String, Item> items) {
		if (!items.containsKey(inputBuyItem)) {
			throw new IllegalArgumentException(EXIST_ERROR_MESSAGE);
		}
	}

	private static void checkNumber(String inputBuyItem, HashMap<String, Item> items) {
		if (items.get(inputBuyItem).getNumber() < MIN_NUMBER) {
			throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
		}
	}
}
