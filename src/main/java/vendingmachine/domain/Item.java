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

	private static final String NAME = "상품명";
	private static final String COST = "가격";
	private static final String AMOUNT = "수량";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_NUMBER_OF_TYPE_ERROR =
		String.format(ERROR + "상품 정보는 %s, %s, %s의" + NUMBER_OF_TYPE + " 단위로 입력해야 합니다.",
			NAME, COST, AMOUNT);
	private static final String MENTION = "상품 %s의 %s이 ";
	private static final String NON_DIGIT_ERROR = ERROR + MENTION + "숫자여야 합니다.";
	private static final String NOT_DIVISIBLE_BY_TEN_ERROR = ERROR + MENTION + TEN + "으로 나누어 떨어져야 합니다.";
	private static final String INVALID_COST_CONDITION_ERROR = ERROR + COST + "이" + COST_LOWER_BOUND + " 이상이면서 "
		+ TEN + "으로 나누어 떨어져야 합니다.";
	private final String name;
	private final int cost;
	private int amount;

	public Item(final List<String> detailContainer) {
		checkLength(detailContainer);
		this.name = detailContainer.get(NAME_INDEX);
		this.cost = isValid(detailContainer.get(COST_INDEX), COST);
		this.amount = isValid(detailContainer.get(AMOUNT_INDEX), AMOUNT);
	}

	private void checkLength(final List<String> detailContainer) {
		if (detailContainer.size() != NUMBER_OF_TYPE) {
			throw new IllegalArgumentException(INVALID_NUMBER_OF_TYPE_ERROR);
		}
	}

	private int isValid(final String value, final String type) {
		int digit = isNumber(value, type);
		if (type.equals(COST)){
			validateCost(digit);
		}
		if (type.equals(AMOUNT)){
			validateAmount(digit);
		}
		return digit;
	}

	private int isNumber(final String value, final String type) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format(NON_DIGIT_ERROR, name, type));
		}
	}

	private void validateCost(final int cost) {
		if (!isValidRange(cost)) {
			throw new IllegalArgumentException(String.format(INVALID_RANGE_ERROR, name, COST));
		}
		if (!isDivisibleByTen(cost)) {
			throw new IllegalArgumentException(String.format(NOT_DIVISIBLE_BY_TEN_ERROR, name, COST));
		}
	}

	private boolean isValidRange(final int cost) {
		return COST_LOWER_BOUND <= cost;
	}

	private boolean isDivisibleByTen(final int cost) {
		return ZERO == cost % TEN;
	}

	private void validateAmount(final int amount) {
		if (!isValidAmountRange(amount)) {
			throw new IllegalArgumentException(String.format(INVALID_AMOUNT_RANGE_ERROR, name, AMOUNT));
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
