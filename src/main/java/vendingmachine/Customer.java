package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

	private static final String ERROR_MSG_PURCHASE_CUSTOMER_MONEY = "[ERROR] 투입 금액보다 큰 금액의 상품입니다.";

	private int money;

	public void readyToPurchase() {
		inputCustomerMoney();
	}

	public int getMoney() {
		return this.money;
	}

	public void inputCustomerMoney() {
		CustomerView.requestMoney();
		String userInput = Console.readLine();
		try {
			Validator.isNumeric(userInput);
			Validator.coinMinimumCheck(userInput);
			Validator.multipleOfTen(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputCustomerMoney();
		}
		this.money = Integer.parseInt(userInput);
	}

	public void isExpensive(Product product) {
		if (this.money < product.getPrice()) {
			throw new IllegalArgumentException(ERROR_MSG_PURCHASE_CUSTOMER_MONEY);
		}
	}

	public void purchaseProduct(Product product) {
		this.money -= product.getPrice();
		product.sellProduct();
	}

}
