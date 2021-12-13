package vendingmachine.domain;

public class Customer {
	private static final String CAN_NOT_BUY_PRODUCT_MESSAGE = "상품이 투입금액보다 비쌉니다.";
	private int money;

	public Customer(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void purchaseProduct(int productCost) {
		if (productCost > money) {
			throw new IllegalArgumentException(CAN_NOT_BUY_PRODUCT_MESSAGE);
		}
		this.money -= productCost;
	}

	public boolean hasMoney() {
		return money > 0;
	}

}
