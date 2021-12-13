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

	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_FORMAT_ERROR = ERROR + "잘못된 포맷의 입력입니다.";

	private final String name;
	private final int cost;
	private int amount;

	public Item(final List<String> detailContainer) {
		checkLength(detailContainer);
		this.name = detailContainer.get(NAME_INDEX);
		this.cost = isNumber(detailContainer.get(COST_INDEX));
		this.amount = isNumber(detailContainer.get(AMOUNT_INDEX));
		validateCost(cost);
		validateAmount(amount);
	}

	private void checkLength(final List<String> detailContainer) {
		if (detailContainer.size() != NUMBER_OF_TYPE) {
			throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
		}
	}

	private int isNumber(final String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
		}
	}

	private void validateCost(final int cost) {
		if (!isValidCostRange(cost)) {
			throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
		}
		if (!isDivisibleByTen(cost)) {
			throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
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
			throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
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