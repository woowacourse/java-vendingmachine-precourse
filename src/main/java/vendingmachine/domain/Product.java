package vendingmachine.domain;

public class Product {
	private static final int MIN_PRICE = 100;
	private static final int MIN_AMOUNT = 0;

	private static final String NAME_ERROR_MESSAGE = "상품 이름을 잘못 입력했습니다.";
	private static final String PRICE_ERROR_MESSAGE = "상품 가격을 잘못 입력했습니다.";
	private static final String COUNT_ERROR_MESSAGE = "상품 수량을 잘못 입력했습니다.";

	private String name;
	private Money price;
	private int amount;

	public Product(String name, Money price, int amount) throws IllegalArgumentException {
		validateName(name);
		validatePrice(price);
		validateAmount(amount);
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	private void validateName(String name) throws IllegalArgumentException {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
		}
	}

	private void validatePrice(Money price) throws IllegalArgumentException {
		if (price.getAmount() < MIN_PRICE) {
			throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
		}
	}

	private void validateAmount(int amount) throws IllegalArgumentException {
		if (amount < MIN_AMOUNT) {
			throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
		}
	}
}
