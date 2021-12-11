package vendingmachine.model.validator;

import java.util.ArrayList;

public class ProductInfoValidator {

	public static final String IS_LENGTH_THREE_ERROR_MESSAGE = "[ERROR] 상품정보의 입력 포맷에 위반됩니다.";
	public static final String IS_NAME_ONLY_BLANK_ERROR_MESSAGE = "[ERROR] 상품이름이 공백으로만 이루어져 있을 수 없습니다.";
	public static final String IS_UNIQUE_NAME_ERROR_MESSAGE = "[ERROR] 중복된 상품이름을 등록할 수 없습니다.";
	public static final String IS_PROPER_PRICE_ERROR_MESSAGE = "[ERROR] 상품가격은 단 하나의 자연수만 가능합니다.";
	public static final String IS_KEEP_PRICE_MIN_UNIT_ERROR_MESSAGE = "[ERROR] 상품가격의 최소 단위는 10원 입니다.";
	public static final String IS_KEEP_PRICE_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 상품가격은 최소 100원 이상입니다.";
	public static final String IS_PROPER_STOCK_ERROR_MESSAGE = "[ERROR] 상품재고는 단 하나의 자연수만 가능합니다.";
	public static final String IS_KEEP_STOCK_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 상품 재고는 0 이하가 될 수 없습니다.";

	public static final int INDEX_OF_NAME = 0;
	public static final int INDEX_OF_PRICE = 1;
	public static final int INDEX_OF_STOCK = 2;
	public static final int TOTAL_INFO_NUMBER = 3;
	public static final int MIN_UNIT_OF_PRICE = 10;
	public static final int MIN_VALUE_OF_PRICE = 100;
	public static final int MIN_VALUE_OF_STOCK = 0;

	public boolean validate(ArrayList<String[]> splitInfoArrList, String[] splitInfoArr) {
		try {
			isLengthThree(splitInfoArr);
			isNameOnlyBlank(splitInfoArr);
			isUniqueName(splitInfoArrList, splitInfoArr);
			isProperPrice(splitInfoArr);
			isKeepPriceMinUnit(splitInfoArr);
			isKeepPriceMinValue(splitInfoArr);
			isProperStock(splitInfoArr);
			isKeepStockMinValue(splitInfoArr);

			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	private void isLengthThree(String[] splitInfoArr) throws IllegalArgumentException {
		if (splitInfoArr.length != TOTAL_INFO_NUMBER) {
			System.out.println(IS_LENGTH_THREE_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isNameOnlyBlank(String[] splitInfoArr) throws IllegalArgumentException {
		String name = splitInfoArr[INDEX_OF_NAME];

		if (name.trim().length() == 0) {
			System.out.println(IS_NAME_ONLY_BLANK_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isUniqueName(ArrayList<String[]> splitInfoArrList, String[] splitInfoArr) throws
		IllegalArgumentException {
		String name = splitInfoArr[INDEX_OF_NAME];

		for (String[] splitInfoArrAdded : splitInfoArrList) {
			if (splitInfoArrAdded[INDEX_OF_NAME].equals(name)) {
				System.out.println(IS_UNIQUE_NAME_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isProperPrice(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		for (char c : price.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println(IS_PROPER_PRICE_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isKeepPriceMinUnit(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		if (Integer.parseInt(price) % MIN_UNIT_OF_PRICE != 0) {
			System.out.println(IS_KEEP_PRICE_MIN_UNIT_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isKeepPriceMinValue(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		if (Integer.parseInt(price) < MIN_VALUE_OF_PRICE) {
			System.out.println(IS_KEEP_PRICE_MIN_VALUE_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isProperStock(String[] splitInfoArr) throws IllegalArgumentException {
		String stock = splitInfoArr[INDEX_OF_STOCK];

		for (char c : stock.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println(IS_PROPER_STOCK_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isKeepStockMinValue(String[] splitInfoArr) throws IllegalArgumentException {
		String stock = splitInfoArr[INDEX_OF_STOCK];

		if (Integer.parseInt(stock) <= MIN_VALUE_OF_STOCK) {
			System.out.println(IS_KEEP_STOCK_MIN_VALUE_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}
}
