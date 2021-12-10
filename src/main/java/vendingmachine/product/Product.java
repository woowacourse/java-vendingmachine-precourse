package vendingmachine.product;

public class Product {
	private static final int MINIMUM_PRICE = 100;
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;
	private static final int NONE = 0;
	private static final String ERROR_PRICE_NOT_INTEGER = "상품 가격은 숫자만 입력이 가능합니다.";
	private static final String ERROR_PRICE_RANGE = "상품 가격은 100원 이상이어야 합니다.";
	private static final String ERROR_PRICE_DIVISIBLE = "자판기가 보유하는 금액은 10원으로 나누어떨어져야 합니다.";
	private static final String ERROR_QUANTITY_NOT_INTEGER = "상품 수량은 숫자만 입력이 가능합니다.";
	private static final String ERROR_QUANTITY_RANGE = "상품 수량은 0보다 커야 합니다.";
	private static final String ERROR_NOT_LEFT = "해당 상품의 재고가 부족하여 구매할 수 없습니다.";

	private int price;
	private int quantity;

	public Product(String price, String quantity) {
		validatePrice(price);
		validateQuantity(quantity);
	}

	private void validatePrice(String price) {
		validatePriceInteger(price);
		validatePriceMinimum();
		validatePriceDivisible();
	}

	private void validatePriceInteger(String price) {
		try {
			this.price = Integer.parseInt(price);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_INTEGER);
		}
	}

	private void validatePriceMinimum() {
		if (price < MINIMUM_PRICE) {
			throw new IllegalArgumentException(ERROR_PRICE_RANGE);
		}
	}

	private void validatePriceDivisible() {
		if (Math.floorMod(price, MINIMUM_DIVISIBLE_NUMBER) != NONE) {
			throw new IllegalArgumentException(ERROR_PRICE_DIVISIBLE);
		}
	}

	private void validateQuantity(String quantity) {
		validateQuantityInteger(quantity);
		validateQuantityRange();
	}

	private void validateQuantityInteger(String quantity) {
		try {
			this.quantity = Integer.parseInt(quantity);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_QUANTITY_NOT_INTEGER);
		}
	}

	private void validateQuantityRange() {
		if (quantity <= NONE) {
			throw new IllegalArgumentException(ERROR_QUANTITY_RANGE);
		}
	}

	public boolean isPurchasable(int money) {
		if (isEnoughMoney(money) && isRemainStock()) {
			return true;
		}
		return false;
	}

	private boolean isEnoughMoney(int money) {
		if (price > money) {
			return false;
		}
		return true;
	}

	private boolean isRemainStock() {
		if (quantity == NONE) {
			return false;
		}
		return true;
	}

	public int sell() {
		validateOutOfStock();
		quantity--;
		return price;
	}

	private void validateOutOfStock() {
		if (quantity == NONE) {
			throw new IllegalArgumentException(ERROR_NOT_LEFT);
		}
	}
}
