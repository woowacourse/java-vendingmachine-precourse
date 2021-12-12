package vendingmachine.domain;

import static vendingmachine.enums.ErrorMessage.*;

public class Product {
	private static final Money MINIMUM_PRICE = new Money("100");
	private static final int ONE = 1;

	private Name name;
	private Money price;
	private Quantity quantity;

	public Product(Name name, Money price, Quantity quantity) {
		validateMinimumPrice(price);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public void sell() {
		Money money = MoneyRepository.get();
		validateCanSellByMoney(money);
		money.sub(price);
		quantity.sub(ONE);
	}

	public boolean isSameName(Name name) {
		String productName = this.name.get();
		String checkProductName = name.get();
		return productName.equals(checkProductName);
	}

	public boolean canSell() {
		Money money = MoneyRepository.get();
		if (money.isLowerThen(price)) {
			return false;
		}
		if (quantity.isSoldOut()) {
			return false;
		}
		return true;
	}

	private void validateMinimumPrice(Money price) {
		if (price.isLowerThen(MINIMUM_PRICE)) {
			throw new IllegalArgumentException(PRICE_LOWER_THEN_MINIMUM_PRICE_ERROR_MESSAGE.get());
		}
	}

	private void validateCanSellByMoney(Money money) {
		if (money.isLowerThen(price)) {
			throw new IllegalArgumentException(MONEY_LOWER_THEN_PRICE_ERROR_MESSAGE.get());
		}
		if (quantity.isSoldOut()) {
			throw new IllegalArgumentException(PRODUCT_SOLD_OUT_ERROR_MESSAGE.get());
		}
	}
}
