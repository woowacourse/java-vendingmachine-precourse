package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.constant.Constant;
import vendingmachine.constant.Message;
import vendingmachine.utils.ValidateUtils;

public class Product {

	private final String name;
	private final int price;
	private int quantity;

	private Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static Product fromProductInformation(String productInformation) {
		String[] information = splitProductInformation(productInformation);
		validateInputProduct(productInformation, information);
		return new Product(information[0], Integer.parseInt(information[1]), Integer.parseInt(information[2]));
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	private static void validateInputProduct(String inputProductInformation, String[] information) {
		if (!ValidateUtils.isValidInputType(inputProductInformation)) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_PRODUCT_INPUT_TYPE);
		}
		if (!ValidateUtils.isDigits(information[1], information[2])) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_PRICE_AND_QUANTITY_TYPE);
		}
		if (!ValidateUtils.isValidPrice(Integer.parseInt(information[1]))) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_PRICE);
		}
	}

	private static String[] splitProductInformation(String product) {
		return product.substring(1, product.length() - 1).split(Constant.COMMA);
	}

	public void validatePossibleToPurchase(Product product, int userMoney) {
		if (product.getQuantity() == Constant.ZERO) {
			throw new IllegalArgumentException(Message.ERROR_SOLD_OUT_PRODUCT);
		}
		if (product.getPrice() > userMoney) {
			throw new IllegalArgumentException(Message.ERROR_NOT_ENOUGH_MONEY);
		}
	}

	public void reduceQuantity() {
		quantity--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return name.equals(product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
