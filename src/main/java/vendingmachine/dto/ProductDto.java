package vendingmachine.dto;

import vendingmachine.domain.machine.product.Product;
import vendingmachine.exception.PriceNotMoreThanMinimumAmountMessageException;
import vendingmachine.exception.PriceNotMultipleOfTenMessageException;
import vendingmachine.exception.QuantityNotPositiveMessageException;

public class ProductDto {

	private String name;
	private int price;
	private int quantity;

	public ProductDto(String name, int price, int quantity) {
		validatePrice(price);
		validateQuantity(quantity);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	private void validatePrice(int price) {
		validatePriceIsMoreThanMinimumAmount(price);
		validatePriceIsMultipleOfTen(price);
	}

	private void validatePriceIsMoreThanMinimumAmount(int price) {
		if (price < 100) {
			throw new PriceNotMoreThanMinimumAmountMessageException();
		}
	}

	private void validatePriceIsMultipleOfTen(int price) {
		if (price % 10 != 0) {
			throw new PriceNotMultipleOfTenMessageException();
		}
	}

	private void validateQuantity(int quantity) {
		validateQuantityIsPositive(quantity);
	}

	private void validateQuantityIsPositive(int quantity) {
		if (quantity <= 0) {
			throw new QuantityNotPositiveMessageException();
		}
	}

	public Product toEntity() {
		return new Product(name, price, quantity);
	}

}
