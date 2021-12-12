package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class MachineController {

	private static final String REQUEST_MSG_INPUT_PRODUCT_NAME = "구입할 상품명을 입력해 주세요.";

	private final Machine machine;
	private final Customer customer;

	public MachineController() {
		this.machine = new Machine();
		this.machine.readyToOpen();
		this.customer = new Customer();
		this.customer.readyToPurchase();
	}

	public void startMachine() {
		do {
			this.customer.printCustomerMoney();
			machineOpen();
		} while (this.machine.minimumMoneyCheck(this.customer));
		this.customer.printCustomerMoney();
		this.machine.giveTheChange(this.customer);
	}

	public void machineOpen() {
		String productName = inputProductName();
		try {
			Product product = machine.findProduct(productName);
			this.customer.isExpensive(product);
			product.isSoldOut();
			this.customer.purchaseProduct(product);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			machineOpen();
		}
	}

	public String inputProductName() {
		System.out.println(REQUEST_MSG_INPUT_PRODUCT_NAME);
		String userInput = Console.readLine();
		try {
			Validator.isNull(userInput);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			inputProductName();
		}
		return userInput.trim();
	}

}
