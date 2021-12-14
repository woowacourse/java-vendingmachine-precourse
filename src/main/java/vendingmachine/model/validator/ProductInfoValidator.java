package vendingmachine.model.validator;

import java.util.ArrayList;

public class ProductInfoValidator {

	public static final String IS_LENGTH_THREE_ERROR_MESSAGE = "[ERROR] 상품정보의 입력 포맷에 위반됩니다.";
	public static final String IS_NAME_NOT_BLANK_ERROR_MESSAGE = "[ERROR] 상품이름이 공백으로만 이루어져 있을 수 없습니다.";
	public static final String IS_UNIQUE_NAME_ERROR_MESSAGE = "[ERROR] 중복된 상품이름을 등록할 수 없습니다.";
	public static final String IS_PRICE_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 상품가격은 단 하나의 자연수만 가능합니다.";
	public static final String IS_PRICE_KEEP_MIN_UNIT_ERROR_MESSAGE = "[ERROR] 상품가격의 최소 단위는 10원 입니다.";
	public static final String IS_PRICE_KEEP_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 상품가격은 최소 100원 이상입니다.";
	public static final String IS_STOCK_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 상품재고는 단 하나의 자연수만 가능합니다.";
	public static final String IS_STOCK_KEEP_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 상품 재고는 0 이하가 될 수 없습니다.";

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
			isNameNotBlank(splitInfoArr);
			isUniqueName(splitInfoArrList, splitInfoArr);
			isPriceNaturalNumber(splitInfoArr);
			isPriceKeepMinUnit(splitInfoArr);
			isPriceKeepMinValue(splitInfoArr);
			isStockNaturalNumber(splitInfoArr);
			isStockKeepMinValue(splitInfoArr);
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

	private void isNameNotBlank(String[] splitInfoArr) throws IllegalArgumentException {
		String name = splitInfoArr[INDEX_OF_NAME];

		if (name.trim().length() == 0) {
			System.out.println(IS_NAME_NOT_BLANK_ERROR_MESSAGE);
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

	private void isPriceNaturalNumber(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		for (char c : price.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println(IS_PRICE_NATURAL_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isPriceKeepMinUnit(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		if (Integer.parseInt(price) % MIN_UNIT_OF_PRICE != 0) {
			System.out.println(IS_PRICE_KEEP_MIN_UNIT_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isPriceKeepMinValue(String[] splitInfoArr) throws IllegalArgumentException {
		String price = splitInfoArr[INDEX_OF_PRICE];

		if (Integer.parseInt(price) < MIN_VALUE_OF_PRICE) {
			System.out.println(IS_PRICE_KEEP_MIN_VALUE_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isStockNaturalNumber(String[] splitInfoArr) throws IllegalArgumentException {
		String stock = splitInfoArr[INDEX_OF_STOCK];

		for (char c : stock.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println(IS_STOCK_NATURAL_NUMBER_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isStockKeepMinValue(String[] splitInfoArr) throws IllegalArgumentException {
		String stock = splitInfoArr[INDEX_OF_STOCK];

		if (Integer.parseInt(stock) <= MIN_VALUE_OF_STOCK) {
			System.out.println(IS_STOCK_KEEP_MIN_VALUE_ERROR_MESSAGE);

			throw new IllegalArgumentException();
		}
	}
}
