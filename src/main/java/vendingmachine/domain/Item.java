package vendingmachine.domain;

import java.util.List;

public class Item {
	private static final int ZERO = 0;
	private static final int TEN = 10;
	private static final int COST_LOWER_BOUND = 100;
	private static final int NUMBER_OF_TYPE = 3;
	private static final String NAME = "상품명";
	private static final String COST = "가격";
	private static final String AMOUNT = "수량";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_NUMBER_OF_TYPE_ERROR = ERROR + "상품 정보는 " + NAME + ", " + COST + ", " + AMOUNT
		+ "의 세 단위로 입력해야 합니다.";
	private static final String NON_DIGIT_ERROR = ERROR + "%s이 숫자여야 합니다.";
	private static final String INVALID_COST_CONDITION_ERROR = ERROR + COST + "이" + COST_LOWER_BOUND + " 이상이면서 "
		+ TEN + "으로 나누어 떨어져야 합니다.";

	private final String name;
	private final int cost;
	private int amount;

	public Item(List<String> detailContainer) {
		checkLength(detailContainer);
		this.name = detailContainer.get(0);
		this.cost = isNumber(detailContainer.get(1), COST);
		validateCost(cost);
		this.amount = isNumber(detailContainer.get(2), AMOUNT);

	}

	private void checkLength(List<String> detailContainer) {
		if (detailContainer.size() != NUMBER_OF_TYPE) {
			throw new IllegalArgumentException(INVALID_NUMBER_OF_TYPE_ERROR);
		}
	}

	private int isNumber(String value, String type) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format(NON_DIGIT_ERROR, type));
		}
	}

	private void validateCost(int cost) {
		if (!isValidRange(cost) || !isDivisibleByTen(cost)) {
			throw new IllegalArgumentException(INVALID_COST_CONDITION_ERROR);
		}
	}

	private boolean isDivisibleByTen(int cost){
		return ZERO == cost % TEN;
	}

	private boolean isValidRange(int cost){
		return COST_LOWER_BOUND <= cost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}

	public void sell() {
		amount --;
	}

	public boolean isSellable() {
		return ZERO < amount;
	}
}
