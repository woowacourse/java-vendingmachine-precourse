package vendingmachine;

public class CustomerView {

	private static final String REQUEST_MSG_INPUT_CUSTOMER_MONEY = "투입 금액을 입력해 주세요.";
	private static final String INFORMATION_MSG_CUSTOMER_MONEY = "투입 금액: ";
	private static final String INFORMATION_MSG_UNIT_OF_MONEY_ = "원";

	public static void requestMoney() {
		System.out.println(REQUEST_MSG_INPUT_CUSTOMER_MONEY);
	}

	public static void printCustomerMoney(Customer customer) {
		System.out.println(INFORMATION_MSG_CUSTOMER_MONEY + customer.getMoney() + INFORMATION_MSG_UNIT_OF_MONEY_);
	}
}
