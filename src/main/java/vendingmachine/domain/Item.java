package vendingmachine.domain;

import java.util.List;

public class Item {
	private static final int ZERO = 0;
	private static final int TEN = 10;
	private static final int COST_LOWER_BOUND = 100;
	private static final int AMOUNT_LOWER_BOUND = ZERO;
	private static final int NUMBER_OF_TYPE = 3;
	private static final int NAME_INDEX = 0;
	private static final int COST_INDEX = 1;
	private static final int AMOUNT_INDEX = 2;

	private static final String COST = "가격";
	private static final String AMOUNT = "수량";
	private static final String ERROR = "[ERROR] ";
	private static final String ERROR_INVALID_NUMBER_OF_TYPE = ERROR + "상품 정보는 %s, %s, %s의 %d 단위로 입력해야 합니다.";
	private static final String ERROR_NON_DIGIT = ERROR + "상품 %s의 %s이 숫자여야 합니다.";
	private static final String ERROR_NOT_DIVISIBLE_BY_TEN = ERROR + "상품 %s의 %s이 %d으로 나누어 떨어져야 합니다.";
	private static final String ERROR_INVALID_DIGIT_RANGE = ERROR + "상품 %s의 %s이 %d 이상이여야 합니다.";

	private final String name;
	private final int cost;
	private int amount;

	public Item(final List<String> detailContainer) {
		checkLength(detailContainer);
		this.name = detailContainer.get(NAME_INDEX);
		this.cost = isNumber(detailContainer.get(COST_INDEX), COST);
		this.amount = isNumber(detailContainer.get(AMOUNT_INDEX), AMOUNT);
		validateCost(cost);
		validateAmount(amount);
	}

	private void checkLength(final List<String> detailContainer) {
		if (detailContainer.size() != NUMBER_OF_TYPE) {
			throw new IllegalArgumentException(
				String.format(ERROR_INVALID_NUMBER_OF_TYPE, "상품명", COST, AMOUNT, NUMBER_OF_TYPE));
		}
	}

	private int isNumber(final String value, final String type) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format(ERROR_NON_DIGIT, name, type));
		}
	}

	private void validateCost(int cost) {
		if (!isValidCostRange(cost)) {
			throw new IllegalArgumentException(String.format(ERROR_INVALID_DIGIT_RANGE, name, COST, COST_LOWER_BOUND));
		}
		if (!isDivisibleByTen(cost)) {
			throw new IllegalArgumentException(String.format(ERROR_NOT_DIVISIBLE_BY_TEN, name, COST, TEN));
		}
	}

	private boolean isValidCostRange(final int cost) {
		return COST_LOWER_BOUND <= cost;
	}

	private boolean isDivisibleByTen(final int cost) {
		return ZERO == cost % TEN;
	}

	private void validateAmount(final int amount) {
		if (!isValidAmountRange(amount)) {
			throw new IllegalArgumentException(ERROR_INVALID_DIGIT_RANGE);
		}
	}

	private boolean isValidAmountRange(final int amount) {
		return AMOUNT_LOWER_BOUND <= amount;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public int getAmount() {
		return amount;
	}

	public void sell() {
		amount--;
	}

	public boolean isStockExist() {
		return ZERO < amount;
	}
}
