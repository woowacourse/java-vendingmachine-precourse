package vendingmachine.domain;

public class Money {
	private static final String ERROR_USER_INPUT_MONEY_IS_NOT_ENOUGH = "[ERROR] 금액이 부족합니다.";
	public static final String PRINT_WON = "원";
	private int price;

	Money(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int reducePrice(int payMoney) {
		price -= payMoney;
		return price;
	}

	public void inputUserMoneyUnderProductPrice(int productPrice) {
		if (productPrice > price) {
			throw new IllegalArgumentException(ERROR_USER_INPUT_MONEY_IS_NOT_ENOUGH);
		}
	}

	@Override
	public String toString() {
		return price + PRINT_WON;
	}

}
