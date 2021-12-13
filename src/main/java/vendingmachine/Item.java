package vendingmachine;

/**
 * 상품의 역할을 하는 model class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class Item {
	private static final int MIN_PRICE = 100;
	private static final int PRICE_UNIT = 10;
	private static final int MIN_COUNT = 1;

	private final int price;
	private int count;

	public Item(int price, int count) {
		validateItemPrice(price);
		validateItemCount(count);
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void takeOne() {
		count--;
	}

	public boolean isSoldOut() {
		return count == 0;
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

}
