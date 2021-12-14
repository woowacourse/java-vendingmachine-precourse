package vendingmachine.domain;

import java.util.Objects;

import vendingmachine.utils.ValidateUtils;

public class Product {

	private static final String ERROR_INVALID_PRICE_AND_QUANTITY_TYPE = "상품의 가격, 수량 입력이 잘못되었습니다.";
	private static final String ERROR_INVALID_PRICE = "상품의 가격은 100원 이상, 10원으로 나누어떨어져야합니다.";
	private static final String ERROR_SOLD_OUT_PRODUCT = "상품의 재고가 모두 소진되었습니다.";
	private static final String ERROR_NOT_ENOUGH_MONEY = "금액이 부족합니다.";
	private static final String ERROR_INVALID_PRODUCT_INPUT_TYPE = "상품 정보 입력 형식을 다시 확인해주세요";
	private static final String COMMA = ",";
	private static final int ZERO = 0;

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
			throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_INPUT_TYPE);
		}
		if (!ValidateUtils.isDigits(information[1], information[2])) {
			throw new IllegalArgumentException(ERROR_INVALID_PRICE_AND_QUANTITY_TYPE);
		}
		if (!ValidateUtils.isValidPrice(Integer.parseInt(information[1]))) {
			throw new IllegalArgumentException(ERROR_INVALID_PRICE);
		}
	}

	private static String[] splitProductInformation(String product) {
		return product.substring(1, product.length() - 1).split(COMMA);
	}

	public void validatePossibleToPurchase(Product product, int userMoney) {
		if (product.getQuantity() == ZERO) {
			throw new IllegalArgumentException(ERROR_SOLD_OUT_PRODUCT);
		}
		if (product.getPrice() > userMoney) {
			throw new IllegalArgumentException(ERROR_NOT_ENOUGH_MONEY);
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
