package vendingmachine.model.item.domain;

import java.util.regex.Pattern;

import vendingmachine.model.shared.Error;
import vendingmachine.model.shared.Validator;

/**
 * 상품의 역할을 하는 model class
 *
 * @author YJGwon
 * @version 1.2
 * @since 1.0
 */
public class Item {
	// 정규식으로 더 자세한 검증을 할 수도 있지만, 사용자에게 각각의 예외 경우에 대한 자세한 안내를 주기 위해 최소한의 형식만 검사
	// 상품명 공백, 가격과 수량 범위까지 검사하는 정규식 : "^\\[\\S+,[1-9][0-9]{3,},[1-9][0-9]*]$"
	private static final String ITEM_REGEX = "^\\[\\S+,[0-9]+,[0-9]+]$";
	private static final String PROPERTY_SEPARATOR = ",";

	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int COUNT_INDEX = 2;

	private static final int MIN_PRICE = 100;
	private static final int PRICE_UNIT = 10;
	private static final int MIN_COUNT = 1;

	private final String name;
	private final int price;
	private int count;

	private Item(String name, int price, int count) {
		validateName(name);
		validateItemPrice(price);
		validateItemCount(count);
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Item from(String stringItem) {
		validateFormat(stringItem);
		String[] properties = tokenizeProperties(stringItem);
		return new Item(properties[NAME_INDEX],
			Validator.stringToInteger(properties[PRICE_INDEX]),
			Validator.stringToInteger(properties[COUNT_INDEX]));
	}

	public int getPrice() {
		return price;
	}

	public void takeOne() {
		count--;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

	public boolean hasSameNameWith(Item item) {
		return isName(item.name);
	}

	public boolean isSoldOut() {
		return count == 0;
	}

	private void validateName(String name) {
		if (!Validator.isBlank(name)) {
			throw new IllegalArgumentException(Error.BLANK.getMassage());
		}
	}

	private void validateItemPrice(int price) {
		if (!Validator.isBiggerThenMinValue(price, MIN_PRICE)) {
			throw new IllegalArgumentException(Error.PRICE_RANGE.getMassage());
		}
		if (!Validator.isDivisible(price, PRICE_UNIT)) {
			throw new IllegalArgumentException(Error.CAN_NOT_BE_DIVIDED_BY_10.getMassage());
		}
	}

	private void validateItemCount(int count) {
		if (!Validator.isBiggerThenMinValue(count, MIN_COUNT)) {
			throw new IllegalArgumentException(Error.COUNT_RANGE.getMassage());
		}
	}

	private static void validateFormat(String input) {
		if (Pattern.matches(ITEM_REGEX, input)) {
			return;
		}
		throw new IllegalArgumentException(Error.ITEM_FORMAT.getMassage());
	}

	private static String[] tokenizeProperties(String stringItem) {
		return stringItem
				.substring((stringItem.indexOf('[') + 1), stringItem.indexOf(']'))
				.split(PROPERTY_SEPARATOR);
	}
}
