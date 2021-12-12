package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

	private static final String REQUEST_MSG_INPUT_CUSTOMER_MONEY = "투입 금액을 입력해 주세요.";
	private static final String ERROR_MSG_PURCHASE_CUSTOMER_MONEY = "[ERROR] 투입 금액보다 큰 금액의 상품입니다.";
	private static final String INFORMATION_MSG_CUSTOMER_MONEY = "투입 금액: ";
	private static final String INFORMATION_MSG_UNIT_OF_MONEY_ = "원";

	private int money;

	public void readyToPurchase() {
		inputCustomerMoney();
	}

	public int getMoney() {
		return this.money;
	}

	public void inputCustomerMoney() {
		System.out.println(REQUEST_MSG_INPUT_CUSTOMER_MONEY);
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

	public void printCustomerMoney() {
		System.out.println(INFORMATION_MSG_CUSTOMER_MONEY + this.money + INFORMATION_MSG_UNIT_OF_MONEY_);
	}
}
